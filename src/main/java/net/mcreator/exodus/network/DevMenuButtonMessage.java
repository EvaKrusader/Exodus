package net.mcreator.exodus.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

import net.mcreator.exodus.procedures.DevProcnightvisProcedure;
import net.mcreator.exodus.procedures.DevProcOverProcedure;
import net.mcreator.exodus.procedures.DevProcNetherProcedure;
import net.mcreator.exodus.procedures.DevProcEndProcedure;
import net.mcreator.exodus.ExodusMod;

@EventBusSubscriber
public record DevMenuButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<DevMenuButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(ExodusMod.MODID, "dev_menu_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DevMenuButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DevMenuButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DevMenuButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<DevMenuButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DevMenuButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			DevProcNetherProcedure.execute(entity);
		}
		if (buttonID == 1) {

			DevProcOverProcedure.execute(entity);
		}
		if (buttonID == 2) {

			DevProcEndProcedure.execute(entity);
		}
		if (buttonID == 3) {

			DevProcnightvisProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		ExodusMod.addNetworkMessage(DevMenuButtonMessage.TYPE, DevMenuButtonMessage.STREAM_CODEC, DevMenuButtonMessage::handleData);
	}
}
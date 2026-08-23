package net.mcreator.exodus.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.ProblemReporter;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.exodus.ExodusMod;

import java.util.function.Supplier;

@EventBusSubscriber
public class ExodusModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, ExodusMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		ExodusMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			for (Entity entityiterator : player.level().players())
				if (entityiterator != player && entityiterator instanceof ServerPlayer playeriterator)
					PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(playeriterator.getData(PLAYER_VARIABLES), playeriterator.getId()));
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
		}
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayersInDimension(player.level(), new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES), player.getId()));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
		clone.howLongChewingGum = original.howLongChewingGum;
		clone.chewingGumLevel = original.chewingGumLevel;
		if (!event.isWasDeath()) {
			clone.phasing_overlay = original.phasing_overlay;
			clone.isGreedy = original.isGreedy;
			clone.greedLevel = original.greedLevel;
			clone.greedLeveler = original.greedLeveler;
			clone.goldAmount = original.goldAmount;
			clone.goldGoal = original.goldGoal;
			clone.fakeGoldLevel = original.fakeGoldLevel;
			clone.hasDeathContract = original.hasDeathContract;
			clone.playContractSound = original.playContractSound;
			clone.deathContractDied = original.deathContractDied;
			clone.latest_trial_level = original.latest_trial_level;
			clone.adrenalineDamage = original.adrenalineDamage;
			clone.healthBeforeAdrenaline = original.healthBeforeAdrenaline;
			clone.isChewingGum = original.isChewingGum;
			clone.chewingGumCounter = original.chewingGumCounter;
			clone.hasNetherCoalEnchant = original.hasNetherCoalEnchant;
			clone.lastFireDamage = original.lastFireDamage;
			clone.hasFireResCharm = original.hasFireResCharm;
			clone.hasFallDamageCharm = original.hasFallDamageCharm;
			clone.cancelFallDamageCharm = original.cancelFallDamageCharm;
			clone.hasXPCharm = original.hasXPCharm;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	public static class PlayerVariables implements ValueIOSerializable {
		boolean _syncDirty = false;
		public double phasing_overlay = 0;
		public boolean isGreedy = false;
		public double greedLevel = 0;
		public double greedLeveler = 0;
		public double goldAmount = 0;
		public double goldGoal = 20.0;
		public double fakeGoldLevel = 0;
		public boolean hasDeathContract = false;
		public boolean playContractSound = false;
		public boolean deathContractDied = false;
		public double latest_trial_level = 0;
		public double adrenalineDamage = 0;
		public double healthBeforeAdrenaline = 20.0;
		public boolean isChewingGum = false;
		public double howLongChewingGum = 0;
		public double chewingGumCounter = 0;
		public double chewingGumLevel = 0;
		public boolean hasNetherCoalEnchant = false;
		public double lastFireDamage = 0;
		public boolean hasFireResCharm = false;
		public boolean hasFallDamageCharm = false;
		public boolean cancelFallDamageCharm = false;
		public boolean hasXPCharm = false;

		@Override
		public void serialize(ValueOutput output) {
			output.putDouble("phasing_overlay", phasing_overlay);
			output.putBoolean("isGreedy", isGreedy);
			output.putDouble("greedLevel", greedLevel);
			output.putDouble("greedLeveler", greedLeveler);
			output.putDouble("goldAmount", goldAmount);
			output.putDouble("goldGoal", goldGoal);
			output.putDouble("fakeGoldLevel", fakeGoldLevel);
			output.putBoolean("hasDeathContract", hasDeathContract);
			output.putBoolean("playContractSound", playContractSound);
			output.putBoolean("deathContractDied", deathContractDied);
			output.putDouble("latest_trial_level", latest_trial_level);
			output.putDouble("adrenalineDamage", adrenalineDamage);
			output.putDouble("healthBeforeAdrenaline", healthBeforeAdrenaline);
			output.putBoolean("isChewingGum", isChewingGum);
			output.putDouble("howLongChewingGum", howLongChewingGum);
			output.putDouble("chewingGumCounter", chewingGumCounter);
			output.putDouble("chewingGumLevel", chewingGumLevel);
			output.putBoolean("hasNetherCoalEnchant", hasNetherCoalEnchant);
			output.putDouble("lastFireDamage", lastFireDamage);
			output.putBoolean("hasFireResCharm", hasFireResCharm);
			output.putBoolean("hasFallDamageCharm", hasFallDamageCharm);
			output.putBoolean("cancelFallDamageCharm", cancelFallDamageCharm);
			output.putBoolean("hasXPCharm", hasXPCharm);
		}

		@Override
		public void deserialize(ValueInput input) {
			phasing_overlay = input.getDoubleOr("phasing_overlay", 0);
			isGreedy = input.getBooleanOr("isGreedy", false);
			greedLevel = input.getDoubleOr("greedLevel", 0);
			greedLeveler = input.getDoubleOr("greedLeveler", 0);
			goldAmount = input.getDoubleOr("goldAmount", 0);
			goldGoal = input.getDoubleOr("goldGoal", 0);
			fakeGoldLevel = input.getDoubleOr("fakeGoldLevel", 0);
			hasDeathContract = input.getBooleanOr("hasDeathContract", false);
			playContractSound = input.getBooleanOr("playContractSound", false);
			deathContractDied = input.getBooleanOr("deathContractDied", false);
			latest_trial_level = input.getDoubleOr("latest_trial_level", 0);
			adrenalineDamage = input.getDoubleOr("adrenalineDamage", 0);
			healthBeforeAdrenaline = input.getDoubleOr("healthBeforeAdrenaline", 0);
			isChewingGum = input.getBooleanOr("isChewingGum", false);
			howLongChewingGum = input.getDoubleOr("howLongChewingGum", 0);
			chewingGumCounter = input.getDoubleOr("chewingGumCounter", 0);
			chewingGumLevel = input.getDoubleOr("chewingGumLevel", 0);
			hasNetherCoalEnchant = input.getBooleanOr("hasNetherCoalEnchant", false);
			lastFireDamage = input.getDoubleOr("lastFireDamage", 0);
			hasFireResCharm = input.getBooleanOr("hasFireResCharm", false);
			hasFallDamageCharm = input.getBooleanOr("hasFallDamageCharm", false);
			cancelFallDamageCharm = input.getBooleanOr("cancelFallDamageCharm", false);
			hasXPCharm = input.getBooleanOr("hasXPCharm", false);
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data, int player) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(ExodusMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, buffer.registryAccess());
			message.data.serialize(output);
			buffer.writeInt(message.player());
			buffer.writeNbt(output.buildResult());
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables(), buffer.readInt());
			message.data.deserialize(TagValueInput.create(ProblemReporter.DISCARDING, buffer.registryAccess(), buffer.readNbt()));
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					Entity player = context.player().level().getEntity(message.player);
					if (player == null)
						return;
					TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, context.player().registryAccess());
					message.data.serialize(output);
					player.getData(PLAYER_VARIABLES).deserialize(TagValueInput.create(ProblemReporter.DISCARDING, context.player().registryAccess(), output.buildResult()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
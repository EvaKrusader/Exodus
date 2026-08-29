package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.exodus.world.inventory.DevMenuMenu;
import net.mcreator.exodus.network.ExodusModVariables;

import io.netty.buffer.Unpooled;

public class DevUIOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).showDevUI == true) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.showDevUI = false;
				_vars.markSyncDirty();
			}
		} else {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.showDevUI = true;
				_vars.markSyncDirty();
			}
		}
		if (entity.isShiftKeyDown()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				_ent.openMenu(new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("DevMenu");
					}

					@Override
					public boolean shouldTriggerClientSideContainerClosingOnOpen() {
						return false;
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new DevMenuMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
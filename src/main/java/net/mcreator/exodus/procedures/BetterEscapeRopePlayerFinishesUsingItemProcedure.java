package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.exodus.network.ExodusModVariables;

public class BetterEscapeRopePlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double isAir = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		{
			Entity _ent = entity;
			double _tx = entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnX;
			double _ty = entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnY;
			double _tz = entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnZ;
			_ent.teleportTo(_tx, _ty, _tz);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
		}
		itemstack.shrink(1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnX, entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnY, entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnZ),
						BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound(entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnX, entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnY, entity.getData(ExodusModVariables.PLAYER_VARIABLES).spawnZ,
						BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
	}
}
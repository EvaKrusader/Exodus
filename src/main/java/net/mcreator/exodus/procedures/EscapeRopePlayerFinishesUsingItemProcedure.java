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

public class EscapeRopePlayerFinishesUsingItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double isAir = 0;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean found = false;
		isAir = 256;
		for (int _i1 = 0; _i1 < 256; _i1++) {
			if (world.getBlockState(BlockPos.containing(x, isAir, z)).canOcclude() == false) {
				isAir = isAir - 1;
			} else {
				{
					Entity _ent = entity;
					double _tx = x;
					double _ty = (isAir + 1);
					double _tz = z;
					_ent.teleportTo(_tx, _ty, _tz);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
				}
				itemstack.shrink(1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, isAir + 1, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1);
					} else {
						_level.playLocalSound(x, (isAir + 1), z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
					}
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("exodus:escape_rope")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
					}
				}
				break;
			}
		}
	}
}
package net.mcreator.exodus.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class GridworldPlayerEntersDimensionProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(new BlockPos(0, 0, 0), Blocks.COBBLESTONE.defaultBlockState(), 3);
		world.setBlock(new BlockPos(0, 1, 0), Blocks.TORCH.defaultBlockState(), 3);
		{
			Entity _ent = entity;
			double _tx = 0.5;
			double _ty = 1;
			double _tz = 0.5;
			_ent.teleportTo(_tx, _ty, _tz);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
		}
	}
}
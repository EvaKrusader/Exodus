package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

public class EasyBakeOvenGenerateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.floor((world instanceof Level _level0 ? _level0.getDefaultClockTime() : 0) / 24000d) == Mth.nextInt(RandomSource.create(), 1, 1000)) {
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.CAKE.defaultBlockState(), 3);
		}
	}
}
package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;

public class CreeperPatcher2BlockDestroyedByPlayerProcedure {
	public static void execute(LevelAccessor world) {
		DevLoadGoldValuesProcedure.execute(world);
		DevLoadEnchantmentValuesProcedure.execute(world);
	}
}
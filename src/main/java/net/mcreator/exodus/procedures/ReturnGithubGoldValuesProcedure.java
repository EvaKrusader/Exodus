package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.exodus.network.ExodusModVariables;

public class ReturnGithubGoldValuesProcedure {
	public static String execute(LevelAccessor world) {
		return ("Gold Block / Raw Gold Block / Gold Ore" + new java.text.DecimalFormat("##.##").format(ExodusModVariables.WorldVariables.get(world).goldVal_gold_block)) + " | "
				+ new java.text.DecimalFormat("##.##").format(ExodusModVariables.WorldVariables.get(world).goldVal_raw_gold_block) + " | " + new java.text.DecimalFormat("##.##").format(ExodusModVariables.WorldVariables.get(world).goldVal_gold_ore);
	}
}
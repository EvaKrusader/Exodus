package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class ReturnOminousLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "OminousLevel : " + new java.text.DecimalFormat("##.##").format(entity.getData(ExodusModVariables.PLAYER_VARIABLES).latest_trial_level);
	}
}
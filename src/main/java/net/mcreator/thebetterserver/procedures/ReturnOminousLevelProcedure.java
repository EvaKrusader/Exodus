package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class ReturnOminousLevelProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "OminousLevel : " + new java.text.DecimalFormat("##.##").format(entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).latest_trial_level);
	}
}
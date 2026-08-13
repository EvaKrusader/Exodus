package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class ReturnGoldGoalProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "goldGoal : " + new java.text.DecimalFormat("#.###").format(entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).goldGoal);
	}
}
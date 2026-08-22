package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class ReturnGreedyProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		String result = "";
		if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).isGreedy == true) {
			result = "true";
		} else {
			result = "false";
		}
		return "isGreedy : " + result;
	}
}
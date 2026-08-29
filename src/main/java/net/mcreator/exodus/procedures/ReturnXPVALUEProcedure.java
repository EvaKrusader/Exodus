package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class ReturnXPVALUEProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "crescent chance : " + new java.text.DecimalFormat("##.##").format(entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance);
	}
}
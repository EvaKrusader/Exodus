package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;

public class ReturnAdrenalineDamageProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "AdrenalineDamage : " + new java.text.DecimalFormat("##.##").format(entity.getData(ExodusModVariables.PLAYER_VARIABLES).adrenalineDamage);
	}
}
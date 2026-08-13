package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class OminousLanternLevelProviderProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).latest_trial_level;
	}
}
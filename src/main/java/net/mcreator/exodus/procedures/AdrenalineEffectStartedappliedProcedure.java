package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;

public class AdrenalineEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ExodusModMobEffects.ADRENALINE)) == false) {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.healthBeforeAdrenaline = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
				_vars.adrenalineDamage = 0;
				_vars.markSyncDirty();
			}
		}
	}
}
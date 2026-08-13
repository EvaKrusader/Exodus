package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;
import net.mcreator.thebetterserver.init.TheBetterServerModMobEffects;

public class AdrenalineEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheBetterServerModMobEffects.ADRENALINE)) == false) {
			{
				TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
				_vars.healthBeforeAdrenaline = entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1;
				_vars.adrenalineDamage = 0;
				_vars.markSyncDirty();
			}
		}
	}
}
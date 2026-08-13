package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;
import net.mcreator.thebetterserver.init.TheBetterServerModMobEffects;

public class AdrenalineTakeDamageProcProcedure {
	public static void execute(Entity entity, double amount) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheBetterServerModMobEffects.ADRENALINE)) == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
			{
				TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
				_vars.adrenalineDamage = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).adrenalineDamage + amount;
				_vars.markSyncDirty();
			}
		}
	}
}
package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.network.ExodusModVariables;
import net.mcreator.exodus.init.ExodusModMobEffects;

public class AdrenalineTakeDamageProcProcedure {
	public static void execute(Entity entity, double amount) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ExodusModMobEffects.ADRENALINE)) == true) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + amount));
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.adrenalineDamage = entity.getData(ExodusModVariables.PLAYER_VARIABLES).adrenalineDamage + amount;
				_vars.markSyncDirty();
			}
		}
	}
}
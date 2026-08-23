package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;

import net.mcreator.exodus.network.ExodusModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CharmOfFireResistanceLastFireDamageProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingDamageEvent.Pre event) {
		if (event.getEntity() != null) {
			execute(event, event.getSource(), event.getEntity(), event.getOriginalDamage());
		}
	}

	public static void execute(DamageSource damagesource, Entity entity, double amount) {
		execute(null, damagesource, entity, amount);
	}

	private static void execute(@Nullable Event event, DamageSource damagesource, Entity entity, double amount) {
		if (damagesource == null || entity == null)
			return;
		double fire_damage = 0;
		if (damagesource.is(DamageTypes.LAVA) || damagesource.is(DamageTypes.ON_FIRE) || damagesource.is(DamageTypes.IN_FIRE)) {
			if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).hasFireResCharm == true) {
				{
					ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
					_vars.lastFireDamage = amount;
					_vars.markSyncDirty();
				}
			}
		}
	}
}
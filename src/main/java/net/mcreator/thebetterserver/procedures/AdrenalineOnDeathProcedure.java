package net.mcreator.thebetterserver.procedures;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;
import net.mcreator.thebetterserver.init.TheBetterServerModMobEffects;
import net.mcreator.thebetterserver.TheBetterServerMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class AdrenalineOnDeathProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheBetterServerModMobEffects.ADRENALINE)) == true) {
			if (event instanceof ICancellableEvent _cancellable) {
				_cancellable.setCanceled(true);
			}
			TheBetterServerMod.queueServerWork(10, () -> {
				if (entity instanceof LivingEntity _entity)
					_entity.setHealth((float) entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES).healthBeforeAdrenaline);
			});
		}
	}
}
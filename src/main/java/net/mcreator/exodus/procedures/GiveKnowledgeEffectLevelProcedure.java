package net.mcreator.exodus.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerXpEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.exodus.init.ExodusModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class GiveKnowledgeEffectLevelProcedure {
	@SubscribeEvent
	public static void onPlayerXPLevelChange(PlayerXpEvent.LevelChange event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity(), event.getLevels());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ExodusModMobEffects.KNOWLEDGE, (int) (amount * 60 * 20), 0, false, false));
	}
}
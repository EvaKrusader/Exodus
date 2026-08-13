package net.mcreator.thebetterserver.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.thebetterserver.procedures.AdrenalineTakeDamageProcProcedure;
import net.mcreator.thebetterserver.procedures.AdrenalineEffectStartedappliedProcedure;

public class AdrenalineMobEffect extends MobEffect {
	public AdrenalineMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		AdrenalineEffectStartedappliedProcedure.execute(entity);
	}

	@Override
	public void onMobHurt(ServerLevel level, LivingEntity entity, int amplifier, DamageSource damagesource, float damage) {
		AdrenalineTakeDamageProcProcedure.execute(entity, damage);
	}
}
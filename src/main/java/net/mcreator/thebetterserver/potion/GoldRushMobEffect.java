package net.mcreator.thebetterserver.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.thebetterserver.procedures.GoldRushEffectStartedappliedProcedure;

public class GoldRushMobEffect extends MobEffect {
	public GoldRushMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -3355648);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GoldRushEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}
}
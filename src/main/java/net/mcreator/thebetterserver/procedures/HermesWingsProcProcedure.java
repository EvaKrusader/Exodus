package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;

public class HermesWingsProcProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.onGround() == false && entity.isShiftKeyDown() == true) {
			if (entity instanceof LivingEntity _entity2 && !_entity2.level().isClientSide())
				_entity2.forceAddEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 5, 0, false, false), null);
			if (0.25 / 5 > Math.random()) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
		}
	}
}
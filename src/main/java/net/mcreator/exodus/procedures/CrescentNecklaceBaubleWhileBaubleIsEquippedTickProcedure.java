package net.mcreator.exodus.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.exodus.network.ExodusModVariables;

public class CrescentNecklaceBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double effectChance = 0;
		if ((world instanceof Level _lvl0 && _lvl0.isBrightOutside()) == false) {
			if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 0) {
				{
					ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
					_vars.crescent_chance = Mth.nextInt(RandomSource.create(), 1, 10);
					_vars.markSyncDirty();
				}
				if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 1) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 100 * 100, 0, false, false));
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.crescent_chance = 7;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 2) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.STRENGTH, 100 * 100, 2, false, false));
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.crescent_chance = 7;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 3) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SPEED, 100 * 100, 2, false, false));
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.crescent_chance = 7;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 4) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 100 * 100, 2, false, false));
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.crescent_chance = 7;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 5) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.HASTE, 100 * 100, 2, false, false));
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.crescent_chance = 7;
						_vars.markSyncDirty();
					}
				} else if (entity.getData(ExodusModVariables.PLAYER_VARIABLES).crescent_chance == 6) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 100 * 100, 2, false, false));
					{
						ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
						_vars.crescent_chance = 7;
						_vars.markSyncDirty();
					}
				}
			}
		} else {
			{
				ExodusModVariables.PlayerVariables _vars = entity.getData(ExodusModVariables.PLAYER_VARIABLES);
				_vars.crescent_chance = 0;
				_vars.markSyncDirty();
			}
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.SPEED) ? _livEnt.getEffect(MobEffects.SPEED).getAmplifier() : 0) == 2) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SPEED);
			}
		}
	}
}
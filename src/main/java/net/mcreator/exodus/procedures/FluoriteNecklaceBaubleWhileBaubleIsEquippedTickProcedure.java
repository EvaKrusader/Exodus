package net.mcreator.exodus.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;

public class FluoriteNecklaceBaubleWhileBaubleIsEquippedTickProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrCldCheck1 && _plrCldCheck1.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(MobEffects.WITHER)) == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WITHER);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, 100);
			}
		}
		if ((entity instanceof Player _plrCldCheck7 && _plrCldCheck7.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt8 && _livEnt8.hasEffect(MobEffects.SLOWNESS)) == true || (entity instanceof LivingEntity _livEnt9 && _livEnt9.hasEffect(MobEffects.MINING_FATIGUE)) == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.SLOWNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MINING_FATIGUE);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, 100);
			}
		}
		if ((entity instanceof Player _plrCldCheck15 && _plrCldCheck15.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(MobEffects.HUNGER)) == true || (entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(MobEffects.WEAKNESS)) == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.HUNGER);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAKNESS);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, 100);
			}
		}
		if ((entity instanceof Player _plrCldCheck23 && _plrCldCheck23.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(MobEffects.BLINDNESS)) == true || (entity instanceof LivingEntity _livEnt25 && _livEnt25.hasEffect(MobEffects.DARKNESS)) == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.BLINDNESS);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.DARKNESS);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, 100);
			}
		}
		if ((entity instanceof Player _plrCldCheck31 && _plrCldCheck31.getCooldowns().isOnCooldown(itemstack)) == false) {
			if ((entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(MobEffects.OOZING)) == true || (entity instanceof LivingEntity _livEnt33 && _livEnt33.hasEffect(MobEffects.WEAVING)) == true
					|| (entity instanceof LivingEntity _livEnt34 && _livEnt34.hasEffect(MobEffects.WIND_CHARGED)) == true) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.OOZING);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WEAVING);
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.WIND_CHARGED);
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack, 100);
			}
		}
	}
}
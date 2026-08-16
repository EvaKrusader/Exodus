package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.exodus.init.ExodusModMobEffects;

public class PhasingOverlayDisplayOverlayIngame3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ExodusModMobEffects.PHASING)) == true) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ExodusModMobEffects.PHASING) ? _livEnt.getEffect(ExodusModMobEffects.PHASING).getDuration() : 0) < 20
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(ExodusModMobEffects.PHASING) ? _livEnt.getEffect(ExodusModMobEffects.PHASING).getDuration() : 0) >= 0) {
				return true;
			}
		}
		return false;
	}
}
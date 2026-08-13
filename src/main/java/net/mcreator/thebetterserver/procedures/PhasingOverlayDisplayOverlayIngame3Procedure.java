package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.thebetterserver.init.TheBetterServerModMobEffects;

public class PhasingOverlayDisplayOverlayIngame3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(TheBetterServerModMobEffects.PHASING)) == true) {
			if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheBetterServerModMobEffects.PHASING) ? _livEnt.getEffect(TheBetterServerModMobEffects.PHASING).getDuration() : 0) < 20
					&& (entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(TheBetterServerModMobEffects.PHASING) ? _livEnt.getEffect(TheBetterServerModMobEffects.PHASING).getDuration() : 0) >= 0) {
				return true;
			}
		}
		return false;
	}
}
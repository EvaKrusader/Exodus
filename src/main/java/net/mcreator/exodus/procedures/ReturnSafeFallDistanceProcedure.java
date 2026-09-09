package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnSafeFallDistanceProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Safe Fall Distance : " + (new java.text.DecimalFormat("##.##")
				.format(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SAFE_FALL_DISTANCE) ? _livingEntity0.getAttribute(Attributes.SAFE_FALL_DISTANCE).getValue() : 0));
	}
}
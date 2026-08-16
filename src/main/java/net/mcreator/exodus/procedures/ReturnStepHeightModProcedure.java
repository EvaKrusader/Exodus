package net.mcreator.exodus.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnStepHeightModProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "ModStepHeight : " + (new java.text.DecimalFormat("##.##")
				.format(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.STEP_HEIGHT) ? _livingEntity0.getAttribute(Attributes.STEP_HEIGHT).getValue() : 0));
	}
}
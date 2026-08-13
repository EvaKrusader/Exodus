package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class ReturnStepHeightBaseProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "BaseStepHeight : " + (new java.text.DecimalFormat("##.##")
				.format(entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.STEP_HEIGHT) ? _livingEntity0.getAttribute(Attributes.STEP_HEIGHT).getBaseValue() : 0));
	}
}
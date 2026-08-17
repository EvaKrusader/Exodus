package net.mcreator.exodus.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;

public class HermesWingsProcProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean stopper = false;
		if (entity.onGround() == false && entity.isShiftKeyDown() == true) {
			if (stopper == false) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0, (entity.getDeltaMovement().z())));
			}
			entity.setNoGravity(true);
			stopper = true;
			if (0.25 / 5 > Math.random()) {
				if (world instanceof ServerLevel _level) {
					itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
					});
				}
			}
		} else {
			entity.setNoGravity(false);
			stopper = false;
		}
	}
}
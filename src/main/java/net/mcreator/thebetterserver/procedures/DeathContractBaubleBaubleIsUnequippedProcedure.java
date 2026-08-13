package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class DeathContractBaubleBaubleIsUnequippedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			final String _tagName = "wasRemoved";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		{
			TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
			_vars.hasDeathContract = false;
			_vars.playContractSound = false;
			_vars.markSyncDirty();
		}
	}
}
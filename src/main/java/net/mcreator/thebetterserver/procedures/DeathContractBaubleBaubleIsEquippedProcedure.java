package net.mcreator.thebetterserver.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.thebetterserver.network.TheBetterServerModVariables;

public class DeathContractBaubleBaubleIsEquippedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		{
			TheBetterServerModVariables.PlayerVariables _vars = entity.getData(TheBetterServerModVariables.PLAYER_VARIABLES);
			_vars.hasDeathContract = true;
			_vars.deathContractDied = false;
			_vars.markSyncDirty();
		}
		{
			final String _tagName = "isSigned";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		{
			final String _tagName = "signedName";
			final String _tagValue = (entity.getDisplayName().getString());
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
		}
	}
}
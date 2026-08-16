package net.mcreator.exodus.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.exodus.procedures.ChewingGumPlayerFinishesUsingItemProcedure;

public class ChewingGumItem extends Item {
	public ChewingGumItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(1).saturationModifier(0f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		ChewingGumPlayerFinishesUsingItemProcedure.execute(entity);
		return retval;
	}
}
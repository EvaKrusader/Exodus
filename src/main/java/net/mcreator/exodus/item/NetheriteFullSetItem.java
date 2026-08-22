package net.mcreator.exodus.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.exodus.procedures.NetheriteFullSetPlayerFinishesUsingItemProcedure;

public class NetheriteFullSetItem extends Item {
	public NetheriteFullSetItem(Item.Properties properties) {
		super(properties.stacksTo(1).food((new FoodProperties.Builder()).nutrition(4).saturationModifier(0.3f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		NetheriteFullSetPlayerFinishesUsingItemProcedure.execute(world, entity);
		return retval;
	}
}
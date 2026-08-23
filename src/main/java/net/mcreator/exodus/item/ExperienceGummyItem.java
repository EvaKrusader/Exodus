package net.mcreator.exodus.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.exodus.procedures.ExperienceGummyPlayerFinishesUsingItemProcedure;

public class ExperienceGummyItem extends Item {
	public ExperienceGummyItem(Item.Properties properties) {
		super(properties.rarity(Rarity.RARE).stacksTo(16).food((new FoodProperties.Builder()).nutrition(1).saturationModifier(1f).alwaysEdible().build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		ExperienceGummyPlayerFinishesUsingItemProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
		return retval;
	}
}
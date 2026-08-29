package net.mcreator.exodus.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.exodus.procedures.ExperienceCrystalPropertyValueProviderProcedure;
import net.mcreator.exodus.procedures.ExperienceCrystalPlayerFinishesUsingItemProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class ExperienceCrystalItem extends Item {
	public ExperienceCrystalItem(Item.Properties properties) {
		super(properties.stacksTo(1).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build(), Consumables.defaultFood().consumeSeconds(2F).build()));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		ExperienceCrystalPlayerFinishesUsingItemProcedure.execute(entity, itemstack);
		return retval;
	}

	public record XpValueProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<XpValueProperty> MAP_CODEC = MapCodec.unit(new XpValueProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) ExperienceCrystalPropertyValueProviderProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<XpValueProperty> type() {
			return MAP_CODEC;
		}
	}
}
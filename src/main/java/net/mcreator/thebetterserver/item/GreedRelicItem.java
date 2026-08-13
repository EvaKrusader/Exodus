package net.mcreator.thebetterserver.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.thebetterserver.procedures.SinfulFaithValueProviderProcedure;
import net.mcreator.thebetterserver.procedures.CreeperRepellentHasItemGlowingEffectProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class GreedRelicItem extends Item {
	public GreedRelicItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return CreeperRepellentHasItemGlowingEffectProcedure.execute();
	}

	public record GreedLevelProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<GreedLevelProperty> MAP_CODEC = MapCodec.unit(new GreedLevelProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) SinfulFaithValueProviderProcedure.execute(owner != null ? owner.level() : clientWorld, itemStackToRender);
		}

		@Override
		public MapCodec<GreedLevelProperty> type() {
			return MAP_CODEC;
		}
	}
}
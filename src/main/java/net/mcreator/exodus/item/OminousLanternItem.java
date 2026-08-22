package net.mcreator.exodus.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import net.mcreator.exodus.procedures.OminousLanternLevelProviderProcedure;
import net.mcreator.exodus.procedures.OminousLanternCoalProviderProcedure;
import net.mcreator.exodus.procedures.CreeperRepellentHasItemGlowingEffectProcedure;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class OminousLanternItem extends Item {
	public OminousLanternItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public boolean isFoil(ItemStack itemstack) {
		return CreeperRepellentHasItemGlowingEffectProcedure.execute();
	}

	public record OminousLevelProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<OminousLevelProperty> MAP_CODEC = MapCodec.unit(new OminousLevelProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) OminousLanternLevelProviderProcedure.execute(owner != null ? owner.asLivingEntity() : null);
		}

		@Override
		public MapCodec<OminousLevelProperty> type() {
			return MAP_CODEC;
		}
	}

	public record HasNetherCoalProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<HasNetherCoalProperty> MAP_CODEC = MapCodec.unit(new HasNetherCoalProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) OminousLanternCoalProviderProcedure.execute(owner != null ? owner.level() : clientWorld, itemStackToRender);
		}

		@Override
		public MapCodec<HasNetherCoalProperty> type() {
			return MAP_CODEC;
		}
	}
}
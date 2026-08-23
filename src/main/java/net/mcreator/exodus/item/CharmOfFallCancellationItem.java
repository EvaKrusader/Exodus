package net.mcreator.exodus.item;

import net.minecraft.world.item.Item;

public class CharmOfFallCancellationItem extends Item {
	public CharmOfFallCancellationItem(Item.Properties properties) {
		super(properties.durability(1).fireResistant());
	}
}
package net.mcreator.exodus.item;

import net.minecraft.world.item.Item;

public class CharmOfFireResistanceItem extends Item {
	public CharmOfFireResistanceItem(Item.Properties properties) {
		super(properties.durability(1).fireResistant());
	}
}
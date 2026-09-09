package net.mcreator.exodus.item;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import net.mcreator.exodus.ExodusMod;

public class RecordGLACEIRItem extends Item {
	public RecordGLACEIRItem(Item.Properties properties) {
		super(properties.stacksTo(1).jukeboxPlayable(ResourceKey.create(Registries.JUKEBOX_SONG, Identifier.fromNamespaceAndPath(ExodusMod.MODID, "record_glaceir"))));
	}
}
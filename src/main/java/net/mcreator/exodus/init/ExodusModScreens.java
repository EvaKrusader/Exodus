/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.exodus.init;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.exodus.client.gui.DevMenuScreen;

@EventBusSubscriber(Dist.CLIENT)
public class ExodusModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(ExodusModMenus.DEV_MENU.get(), DevMenuScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}
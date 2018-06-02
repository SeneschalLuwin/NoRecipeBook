package com.luwin.norecipebook;

import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class EventHandler {

	private static final String PATH0 = "textures/gui/container/crafting_table.png";
	private static final String PATH1 = "textures/gui/container/inventory.png";
	
	private static void removeRecipeGuide(GuiScreen gui, List<GuiButton> button_list) {
		
		for (GuiButton button : button_list) {
	
			if (button instanceof GuiButtonImage) {
				
				GuiButtonImage button_image = (GuiButtonImage) button;
				int button_id = button.id;
				String resource_path = button_image.resourceLocation.getResourcePath();
				
				if (button_id == 10 || resource_path.equals(PATH0) || resource_path.equals(PATH1)) {
					button.visible = false;
				}	
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void InitGui(GuiScreenEvent.InitGuiEvent.Post event) {
		removeRecipeGuide(event.getGui(), event.getButtonList());
	}
	
}

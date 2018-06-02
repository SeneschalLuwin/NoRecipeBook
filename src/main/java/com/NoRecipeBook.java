package com;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.message.AsynchronouslyFormattable;

import com.google.common.collect.Lists;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiButtonImage;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiCrafting;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;


@Mod(modid = "norecipebook", name = "No Recipe Book", version = "1.2.0", acceptedMinecraftVersions = "[1.12,1.12.2]", clientSideOnly = true)
public class NoRecipeBook {
	
	@EventBusSubscriber
	public static class NRBEventHandler {
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public static void InitGui(InitGuiEvent.Post event) {
			GuiScreen gui = event.getGui();
			GuiButton[] target = new GuiButton[gui.buttonList.size()];
			int inc = 0;
			for (GuiButton button : gui.buttonList) {
				if (button.id == 10) {
					target[inc] = button;
					inc++;
				}
			}
			for (GuiButton button : target) {
				gui.buttonList.remove(button);
			}
		}
	}
}

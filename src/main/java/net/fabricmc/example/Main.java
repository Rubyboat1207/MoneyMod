package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main implements ModInitializer {
	public static final String MODID = "rbcrypto";

	@Override
	public void onInitialize() {
		Items.RegisterItems();
	}
}

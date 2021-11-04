package com.rubyboat1207.crypto;

import net.fabricmc.api.ModInitializer;

public class Main implements ModInitializer {
	public static final String MODID = "rbcrypto";

	@Override
	public void onInitialize() {
		Items.RegisterItems();
	}
}

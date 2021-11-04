package com.rubyboat1207.crypto;

import com.rubyboat1207.crypto.CustomItems.Crypto;
import com.rubyboat1207.crypto.CustomItems.CryptoWallet;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class Items {
    public static final Item RUBIES = new Crypto(new FabricItemSettings().maxCount(16).fireproof().rarity(Rarity.EPIC));
    public static final Item CRYPTO_WALLET = new CryptoWallet(new FabricItemSettings().maxCount(1).fireproof().rarity(Rarity.EPIC));

    public static void RegisterItems()
    {
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "ruby"), RUBIES);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "crypto_wallet"), CRYPTO_WALLET);
    }
}

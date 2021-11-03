package net.fabricmc.example;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;


public class Items {
    public static final Item RUBIES = new Item(new FabricItemSettings().maxCount(16).fireproof().rarity(Rarity.EPIC));

    public static void RegisterItems()
    {
        Registry.register(Registry.ITEM, new Identifier(Main.MODID), RUBIES);
    }
}

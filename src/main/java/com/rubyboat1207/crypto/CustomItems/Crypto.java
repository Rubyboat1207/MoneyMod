package com.rubyboat1207.crypto.CustomItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Crypto extends Item {
    private int price = 1;

    public int getPrice()
    {
        return price;
    }

    public Crypto(Settings settings) {
        super(settings);
    }


}

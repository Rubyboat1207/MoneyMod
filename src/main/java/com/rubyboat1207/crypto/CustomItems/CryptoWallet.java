package com.rubyboat1207.crypto.CustomItems;

import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CryptoWallet extends Item {
    public CryptoWallet(Settings settings) {
        super(settings);
    }
    private int ammountOfCrypto = 0;
    public int getCryptoAmmount(ItemStack currentStack)
    {
        UpdateCrypto(currentStack);
        return ammountOfCrypto;
    }
    public void setCryptoAmmount(int ammount, ItemStack currentStack)
    {
        ammountOfCrypto = ammount;
        UpdateCrypto(currentStack);
    }
    public void UpdateCrypto(ItemStack wallet)
    {
        NbtCompound nbtCompound = wallet.getOrCreateNbt();
        if (!nbtCompound.contains("CryptoCount")) {
            nbtCompound.putInt("Crypto", ammountOfCrypto);
        }
        ammountOfCrypto = nbtCompound.getInt("Crypto");
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        UpdateCrypto(stack);
        tooltip.add(Text.of(ammountOfCrypto + " RubyCoins"));
        super.appendTooltip(stack, world, tooltip, context);
    }

}

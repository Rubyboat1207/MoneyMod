package com.rubyboat1207.crypto.CustomItems;

import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;

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
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().getBlockState(context.getBlockPos()).getBlock() == Blocks.AIR)
        {

        }
        return super.useOnBlock(context);
    }


}

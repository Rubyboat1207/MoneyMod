package com.rubyboat1207.crypto.CustomItems;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

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
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack item = user.getInventory().getStack(45);
        if(item.getItem() instanceof Crypto)
        {
            Crypto crypto = (Crypto) item.getItem();
            if(user.getMainHandStack().getItem() instanceof CryptoWallet)
            {
                CryptoWallet wallet = (CryptoWallet) user.getOffHandStack().getItem();
                wallet.setCryptoAmmount(wallet.getCryptoAmmount(user.getOffHandStack()) + user.getInventory().getMainHandStack().getCount() * ((Crypto) item.getItem()).getPrice(), user.getOffHandStack());
                user.getInventory().setStack(45, new ItemStack(Items.AIR));
            }
        }
        return super.use(world, user, hand);
    }

}

package com.rubyboat1207.crypto.CustomItems;

import com.rubyboat1207.crypto.Items;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack item = user.getStackInHand(hand);
        if(item.getItem() instanceof Crypto)
        {
            Crypto crypto = (Crypto) item.getItem();
            if(user.getOffHandStack().getItem() instanceof CryptoWallet)
            {
                CryptoWallet wallet = (CryptoWallet) user.getOffHandStack().getItem();
                wallet.setCryptoAmmount(wallet.getCryptoAmmount(user.getOffHandStack()) + price, user.getOffHandStack());
                user.getMainHandStack().setCount(user.getMainHandStack().getCount() - 1);
            }
        }
        return super.use(world, user, hand);
    }
}

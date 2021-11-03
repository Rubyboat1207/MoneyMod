package net.fabricmc.example.CustomItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Crypto extends Item {
    public static final int PRICE = 1;

    public Crypto(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack item = user.getStackInHand(hand);
        if(item.getItem() instanceof Crypto)
        {

        }
        return super.use(world, user, hand);
    }
}

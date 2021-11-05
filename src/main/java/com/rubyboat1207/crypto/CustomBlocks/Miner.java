package com.rubyboat1207.crypto.CustomBlocks;

import com.rubyboat1207.crypto.CustomItems.CryptoWallet;
import com.rubyboat1207.crypto.Items;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class Miner extends Block implements BlockEntityProvider {
    public Miner(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MinerEntity(pos, state);
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(2) == 0) {
            BlockEntity be = world.getBlockEntity(pos);
            if(be instanceof MinerEntity)
            {
                MinerEntity blockEntity = (MinerEntity) be;
                blockEntity.currentCoins += 1;
            }
        }
        super.randomTick(state, world, pos, random);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {


        BlockEntity be = world.getBlockEntity(pos);

        if(be instanceof MinerEntity)
        {
            MinerEntity blockEntity = (MinerEntity) be;
            if(player.getMainHandStack().getItem() == net.minecraft.item.Items.AIR)
            {
                if(blockEntity.currentCoins >= 16)
                {
                    player.getInventory().insertStack(new ItemStack(Items.RUBIES, 16));
                    blockEntity.currentCoins -= 16;
                }
                else
                {
                    player.getInventory().insertStack(new ItemStack(Items.RUBIES, blockEntity.currentCoins));
                    blockEntity.currentCoins = 0;
                }
                return ActionResult.SUCCESS;
            }
            if(player.getMainHandStack().getItem() == Items.CRYPTO_WALLET)
            {
                CryptoWallet wallet = (CryptoWallet) player.getMainHandStack().getItem();
                wallet.setCryptoAmmount(wallet.getCryptoAmmount(player.getMainHandStack()) + blockEntity.currentCoins, player.getMainHandStack());
                if(blockEntity.currentCoins == 0)
                {
                    return ActionResult.PASS;
                }else
                {
                    blockEntity.currentCoins = 0;
                    return ActionResult.SUCCESS;
                }

            }
        }

        return ActionResult.PASS;
    }
}

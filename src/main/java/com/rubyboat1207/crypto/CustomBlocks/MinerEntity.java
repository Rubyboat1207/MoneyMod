package com.rubyboat1207.crypto.CustomBlocks;

import com.rubyboat1207.crypto.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

public class MinerEntity extends BlockEntity {
    public MinerEntity(BlockPos pos, BlockState state) {
        super(Blocks.RUBYBOAT_MINER_ENTITY, pos, state);
    }
    int currentCoins = 0;
    @Override
    public NbtCompound writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("CoinCount", currentCoins);
        return tag;
    }
    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        currentCoins = tag.getInt("CoinCount");
    }
}

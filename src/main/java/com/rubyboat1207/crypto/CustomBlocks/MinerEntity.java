package com.rubyboat1207.crypto.CustomBlocks;

import com.rubyboat1207.crypto.Blocks;
import com.rubyboat1207.crypto.Main;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

public class MinerEntity extends BlockEntity {
    public MinerEntity(BlockPos pos, BlockState state) {
        super(Blocks.RUBYBOAT_MINER_ENTITY, pos, state);
    }
}

package com.rubyboat1207.crypto;

import com.rubyboat1207.crypto.CustomBlocks.Miner;
import com.rubyboat1207.crypto.CustomBlocks.MinerEntity;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Blocks {

    public static BlockEntityType<MinerEntity> RUBYBOAT_MINER_ENTITY;
    public static Miner MINER = new Miner(FabricBlockSettings.of(Material.METAL).requiresTool().strength(5, 6).luminance(3).sounds(BlockSoundGroup.METAL));

    public static void registerBlocks()
    {
        Registry.register(Registry.BLOCK, new Identifier(Main.MODID, "miner"), MINER);
        Registry.register(Registry.ITEM, new Identifier(Main.MODID, "miner"), new BlockItem(MINER, new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
        RUBYBOAT_MINER_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Main.MODID, "miner"), FabricBlockEntityTypeBuilder.create(MinerEntity::new, MINER).build(null));

    }
}

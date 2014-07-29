package com.w3lch.corruptioncraft.block;

import com.w3lch.corruptioncraft.utils.pathUtils;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Henry Welch on 7/28/2014.
 */
public class CORMOD_Blocks
{
    public static final String CORRUPTED_GRASS_BLOCK_NAME = "corruptedGrass";
    public static final String CORRUPTED_DIRT_BLOCK_NAME = "corruptedDirt";
    public static final String CORRUPTED_STONE_BLOCK_NAME = "corruptedStone";
    public static final String CORRUPTED_GRAVEL_BLOCK_NAME = "corruptedGravel";


    public final static Block CORRUPTED_GRASS =
            new CorruptionGrassBlock(Material.ground)
                    .setHardness(0.5F).setStepSound(Block.soundTypeGravel)
                    .setBlockName(CORRUPTED_GRASS_BLOCK_NAME)
                    .setCreativeTab(CreativeTabs.tabBlock)
                    .setBlockTextureName(pathUtils.getTexturePath(CORRUPTED_GRASS_BLOCK_NAME));

    public final static Block CORRUPTED_DIRT =
            new CorruptionSpreadableBaseBlock(Material.ground)
                    .setHardness(0.5F).setStepSound(Block.soundTypeGravel)
                    .setBlockName(CORRUPTED_DIRT_BLOCK_NAME)
                    .setCreativeTab(CreativeTabs.tabBlock)
                    .setBlockTextureName(pathUtils.getTexturePath(CORRUPTED_DIRT_BLOCK_NAME));

    public final static Block CORRUPTED_STONE =
            new CorruptionSpreadableBaseBlock(Material.ground)
                    .setHardness(0.5F).setStepSound(Block.soundTypeGravel)
                    .setBlockName(CORRUPTED_STONE_BLOCK_NAME)
                    .setCreativeTab(CreativeTabs.tabBlock)
                    .setBlockTextureName(pathUtils.getTexturePath(CORRUPTED_STONE_BLOCK_NAME));

    public final static Block CORRUPTED_GRAVEL =
            new CorruptionSpreadableBaseBlock(Material.ground)
                    .setHardness(0.5F).setStepSound(Block.soundTypeGravel)
                    .setBlockName(CORRUPTED_GRAVEL_BLOCK_NAME)
                    .setCreativeTab(CreativeTabs.tabBlock)
                    .setBlockTextureName(pathUtils.getTexturePath(CORRUPTED_GRAVEL_BLOCK_NAME));


    public static void registerBlocks()
    {
        GameRegistry.registerBlock(CORRUPTED_GRASS, CORRUPTED_GRASS_BLOCK_NAME);
        GameRegistry.registerBlock(CORRUPTED_DIRT, CORRUPTED_DIRT_BLOCK_NAME);
        GameRegistry.registerBlock(CORRUPTED_STONE, CORRUPTED_STONE_BLOCK_NAME);
        GameRegistry.registerBlock(CORRUPTED_GRAVEL, CORRUPTED_GRAVEL_BLOCK_NAME);
    }
}

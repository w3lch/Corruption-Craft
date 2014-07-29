package com.w3lch.corruptioncraft;

import com.w3lch.corruptioncraft.block.CORMOD_Blocks;
import com.w3lch.corruptioncraft.reference.Reference;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.init.Blocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = Reference.MOD_ID, version = Reference.MOD_VERSION, name = Reference.MOD_NAME)
public class CorruptionCraft
{
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some w3lch code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
        CORMOD_Blocks.registerBlocks();
    }

}

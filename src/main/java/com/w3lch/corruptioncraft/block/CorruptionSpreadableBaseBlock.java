package com.w3lch.corruptioncraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Henry Welch on 7/26/2014.
 */

/**
 * corruption block types-- all corrupted blocks spread too their vanilla counter parts using a custom spread algorithm
 * inert corruption blocks do not spread they can be crafted with cleansing dust + the corrupt block
 * to craft cleansing dust you have to have craft corrupted dust glowstone and sunflower dust
 * to craft corrupt dust you crush a corrupt block with (some tool)
 * corruption manager:
 *     Spawns corruption blocks and loads chunks in their area to allow them to grow in a specified direction.
 *     Uses the number of corrupted blocks in the loaded area to decide when to unload certain chunks and load others.
 *     It will get the number of blocks in front of it and after it goes over a certain amount it will unload the chunks
 *         behind it and load more in front of it (towards spawn, or the player).
 *     Moves corruption generally towards the target with a random factor applied, so it may branch off.
 *     The target is either spawn or the player, this will be configurable.
 * corruption bacteria types:
 *     There are multiple corruption infection types, each type has different properties
 *     such as spread speed, and item tier. The tiers are an extension and expansion of the minecraft
 *     tier system, intended to be more complex and challenging.
 *     fel producing:
 *         tier: 2
 *         colors: red, green.
 *         appears second farthest from spawn.
 *         spread speed: faster, double vanilla speed
 *     fungus producing:
 *         tier: 1
 *         colors: blue, purple.
 *         appears closest to spawn.
 *         spread speed: slowest/vanilla speed
 * corrupted stone
 * corrupted grass---will spread and grow like vanilla grass on corrupted dirt
 * corrupted dirt
 * corrupted gravel
 * corrupted sand
 * infected water
 * infected logs
 * infected leaves
 * infected foliage
 * ore type depend on type of corruption
 * infected planks
 * infected door
 * infected cobblestone
 * corrupted glass
 *
 *
 *
 *
 */
public class CorruptionSpreadableBaseBlock extends Block{
    //its the block type to spread gets set when spreading to specific blocks
    private Block spreadBlock;

    private int ticksPerSecond = 20;
    // the number of times blocks have spread this tick
    private int hasSpreadTick = 0;
    // the number of blocks that spread per tick 2
    private int spreadPerTick =2;
    private int tickRate=ticksPerSecond*40;

    public CorruptionSpreadableBaseBlock(Material m){
        super(m);
        setTickRandomly(true);

    }

    @Override
    public void updateTick(World world, int x, int y, int z, Random rad) {

        //System.out.println("ran my blocks update tick "+rad);

        this.spreadToNear( world, x, y, z,rad);



    }
    public boolean spreadToNear(World world ,int x,int y,int z,Random rad)
    {

        int spreadDist = (rad.nextInt(2) + 1);
        //System.out.println("spread distance "+spreadDist);
        if(this.canSpreadToBlock(world.getBlock(x,y-spreadDist,z)) && rad.nextBoolean())
        {
            this.spreadToBlock(world, x,y-spreadDist,z);

            hasSpreadTick++;
        }
        if(this.canSpreadToBlock(world.getBlock(x,y+spreadDist,z)) && hasSpreadTick <= spreadPerTick && rad.nextBoolean())
        {
            this.spreadToBlock(world, x,y+spreadDist,z);

            hasSpreadTick++;
        }

        if(this.canSpreadToBlock(world.getBlock(x-spreadDist,y,z)) && hasSpreadTick <= spreadPerTick && rad.nextBoolean())
        {
            this.spreadToBlock(world, x-spreadDist,y,z);

            hasSpreadTick++;
        }
        if(this.canSpreadToBlock(world.getBlock(x+spreadDist,y,z)) && hasSpreadTick <= spreadPerTick && rad.nextBoolean())
        {
            this.spreadToBlock(world, x+spreadDist,y,z);

            hasSpreadTick++;
        }

        if(this.canSpreadToBlock(world.getBlock(x,y,z-spreadDist)) && hasSpreadTick <= spreadPerTick && rad.nextBoolean())
        {
            this.spreadToBlock(world, x,y,z-spreadDist);

            hasSpreadTick++;
        }
        if(this.canSpreadToBlock(world.getBlock(x,y,z+spreadDist)) && hasSpreadTick <= spreadPerTick && rad.nextBoolean())
        {
            this.spreadToBlock(world, x,y,z+spreadDist);

            hasSpreadTick++;
        }

        hasSpreadTick = 0;
        return true;
    }
    public boolean canSpreadToBlock(Block block){
        if(block==Block.getBlockFromName("grass") )
        {
         //inside the curly braces is a "code block"
            this.spreadBlock = CORMOD_Blocks.CORRUPTED_GRASS;
            return true;
        }
        else if(block==Block.getBlockFromName("stone") )
        {
            //inside the curly braces is a "code block"
            this.spreadBlock = CORMOD_Blocks.CORRUPTED_STONE;
            return true;
        }
        else if(block==Block.getBlockFromName("dirt") )
        {
            //inside the curly braces is a "code block"
            this.spreadBlock = CORMOD_Blocks.CORRUPTED_DIRT;
            return true;
        }
        else if(block==Block.getBlockFromName("gravel") )
        {
            //inside the curly braces is a "code block"
            this.spreadBlock = CORMOD_Blocks.CORRUPTED_GRAVEL;
            return true;
        }
        return false;
    }

    private void spreadToBlock(World world, int x, int y, int z)
    {
        world.setBlock(x, y, z, this.spreadBlock);
        world.playSoundEffect(x, y, z, "mob.spider.step", 1f, 0.05f);
    }
    @Override
    public void onBlockAdded(World world,int x,int y,int z){
        world.scheduleBlockUpdate(x,y,z,this,tickRate);
    }


}


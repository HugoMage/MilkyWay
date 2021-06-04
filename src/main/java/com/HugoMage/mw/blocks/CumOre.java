package com.HugoMage.mw.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class CumOre extends OreBlock implements IForgeBlock
{
    public CumOre() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(1f, 2));
    }



    @Override
    public int getHarvestLevel(BlockState state) {
        return 2;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }

}

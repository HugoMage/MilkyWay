package com.HugoMage.mw.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

public class SemenBlock extends Block implements IForgeBlock
{
    public SemenBlock() {
        super(Properties.create(Material.ORGANIC, MaterialColor.ORANGE_TERRACOTTA).hardnessAndResistance(3f, 2f).sound(SoundType.STONE));
    }



    @Override
    public int getHarvestLevel(BlockState state) {
        return 1;
    }

    @Override
    public ToolType getHarvestTool(BlockState state) {
        return ToolType.PICKAXE;
    }
}

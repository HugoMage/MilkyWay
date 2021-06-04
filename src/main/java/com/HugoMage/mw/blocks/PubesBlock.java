package com.HugoMage.mw.blocks;

import com.HugoMage.mw.util.RegistryHandler;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.extensions.IForgeBlock;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class PubesBlock extends BushBlock
{
    public static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);


    public PubesBlock(Block.Properties builder) {
        super(builder);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        Block block = state.getBlock();
        return block == RegistryHandler.FLESH_BLOCK.get();
    }

}

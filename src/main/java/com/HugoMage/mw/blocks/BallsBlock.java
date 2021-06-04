package com.HugoMage.mw.blocks;

import com.HugoMage.mw.util.RegistryHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.Random;

public class BallsBlock extends Block
{
    public static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 14.0D, 14.0D);


    public BallsBlock(Properties builder) {
        super(builder);
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    protected boolean isStateValid(World worldIn, BlockPos pos) {
        Block block = worldIn.getBlockState(pos.up()).getBlock();
        return block.isIn(BlockTags.BASE_STONE_OVERWORLD) || block.isIn(BlockTags.BASE_STONE_NETHER);
    }
    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, LivingEntity entity) {
        return true;
    }
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        if (worldIn.isRainingAt(pos.up())) {
            if (rand.nextInt(15) == 1) {
                BlockPos blockpos = pos.down();
                BlockState blockstate = worldIn.getBlockState(blockpos);
                if (!blockstate.isSolid() || !blockstate.isSolidSide(worldIn, blockpos, Direction.DOWN)) {
                    double d0 = (double) ((float) pos.getX() + rand.nextFloat());
                    double d1 = (double) pos.getY() - 0.05D;
                    double d2 = (double) ((float) pos.getZ() + rand.nextFloat());
                    worldIn.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }
    @Override
    public void neighborChanged(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean moving) {
        if (world.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()) {
            world.removeBlock(pos, false);
        }
    }
    public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
        return 1;
    }

    @Override
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        return true;
    }
    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getPos();
        if (isStateValid(world, pos)) {
            return getDefaultState();
        }
        return null;
    }
}

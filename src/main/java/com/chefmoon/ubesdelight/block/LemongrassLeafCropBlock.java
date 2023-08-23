package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class LemongrassLeafCropBlock extends CropBlock {
    public static final IntProperty AGE = Properties.AGE_3;
    public static final int MAX_AGE = 3;
    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 4.d, 15.d),
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 8.d, 15.d),
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 10.d, 15.d),
            Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 14.d, 15.d)
    };
    public LemongrassLeafCropBlock() {
        super(FabricBlockSettings.copyOf(Blocks.WHEAT));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE_BY_AGE[state.get(getAgeProperty())];
    }
    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (world.getLightLevel(pos, 0) >= 8 || world.isSkyVisible(pos)) && canPlantOnTop(world.getBlockState(pos.down()), world, pos);
    }
    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(BlocksRegistry.LEMONGRASS_STALK_CROP.get());
    }
    @Override
    protected int getGrowthAmount(World world) {
        return super.getGrowthAmount(world) / 2;
    }
    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }
    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
    protected ItemConvertible getSeedsItem() {
        return ItemsRegistry.LEMONGRASS_SEEDS.get();
    }
}

package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.TagsRegistry;
import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class HaloHaloFeast extends Block {

    public static final int MAX_SERVINGS = 4;
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final IntProperty SERVINGS = IntProperty.of("servings", 0, 4);

    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 8.d, 15.d);

    public final Item servingItem;

    public HaloHaloFeast(Item servingItem) {
        super(FabricBlockSettings.copyOf(Blocks.GLASS));
        this.servingItem = servingItem;
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(SERVINGS, 4));
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, SERVINGS);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        super.onBreak(world, pos, state, player);

        //what happens if broken with servings leftover? TODO
        if (player.getMainHandStack().isIn(TagsRegistry.KNIVES)) {
            HaloHaloFeast haloHaloFeast = (HaloHaloFeast) state.getBlock();
            ItemStack servingItem = haloHaloFeast.getServingStack(state);
            if (state.get(HaloHaloFeast.SERVINGS) > 0) {
                servingItem.setCount(state.get(HaloHaloFeast.SERVINGS));
                ItemScatterer.spawn(world, pos, DefaultedList.ofSize(1, servingItem));
            }
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemstack = player.getStackInHand(hand);

        if (world.isClient()) {
            if (itemstack.isOf(Items.GLASS_BOTTLE) && dispenseDrink(world, pos, state, player, hand).isAccepted()) {
                return ActionResult.SUCCESS;
            }
        }

        if (itemstack.isOf(Items.GLASS_BOTTLE)) {
            return dispenseDrink(world, pos, state, player, hand);
        }
        return ActionResult.FAIL;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSolid();
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState newState, WorldAccess world, BlockPos pos, BlockPos posFrom) {
        return direction == Direction.DOWN && !state.canPlaceAt(world, pos) ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, newState, world, pos, posFrom);
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(getServingsProperty());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public IntProperty getServingsProperty() {
        return SERVINGS;
    }

    public int getMaxServings() {
        return 4;
    }

    public ItemStack getServingStack(BlockState state) {
        return new ItemStack(servingItem);
    }

    protected ActionResult dispenseDrink(World world, BlockPos pos, BlockState state, PlayerEntity player, Hand hand) {
        int servings = state.get(getServingsProperty());

        if (servings == 0) {
            return ActionResult.FAIL;
        }

        ItemStack serving = getServingStack(state);
        ItemStack heldItem = player.getStackInHand(hand);

        if (servings > 0 ) {
            world.setBlockState(pos, state.with(getServingsProperty(), servings - 1), 3);
            if (!player.getAbilities().creativeMode) {
                heldItem.decrement(1);
            }
            if (!player.getInventory().insertStack(serving)) {
                player.dropItem(serving, false);
            }
        }

        world.playSound(null, pos, SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM, SoundCategory.PLAYERS, 0.8F, 0.8F);

        return ActionResult.SUCCESS;
    }
}

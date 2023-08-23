package com.chefmoon.ubesdelight.block;

import com.chefmoon.ubesdelight.block.entity.BakingMatBlockEntity;
import com.chefmoon.ubesdelight.tag.CommonTags;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class BakingMatBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.d, .0d, 1.d, 15.d, 1.d, 15.d);
    public BakingMatBlock() {
        super(FabricBlockSettings.copy(Blocks.OAK_PLANKS).hardness(2.f).resistance(2.f).sounds(BlockSoundGroup.WOOD));
        setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ActionResult result = ActionResult.PASS;
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (!(blockEntity instanceof BakingMatBlockEntity bakingMatBlockEntity)) {
            return result;
        }

        ItemStack itemHeld = player.getStackInHand(hand);

        if (bakingMatBlockEntity.isEmpty()) {
            result = tryAddItemFromPlayerHand(world, bakingMatBlockEntity, player, hand);
        } else if (!itemHeld.isEmpty()) {
            //result = tryProcessCuttingUsingToolInHand(world, bakingMatBlockEntity, player, hand);
        } else if (hand.equals(Hand.MAIN_HAND) && player.isInSneakingPose()) {
            pullOutItemWithPlayer(world, bakingMatBlockEntity, player);
            result = ActionResult.SUCCESS;
        }

        return result;
    }
    private void pullOutItemWithPlayer(World world, BakingMatBlockEntity bakingMatBlockEntity, PlayerEntity player) {
        BlockPos pos = bakingMatBlockEntity.getPos();

        if (player.isCreative()) {
            bakingMatBlockEntity.removeItem();
        } else if (!player.getInventory().insertStack(bakingMatBlockEntity.removeItem())) {
            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), bakingMatBlockEntity.removeItem());
        }

        world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_WOOD_HIT, SoundCategory.BLOCKS, .25f, .5f);
    }
    private ActionResult tryAddItemFromPlayerHand(World world, BakingMatBlockEntity bakingMatBlockEntity, PlayerEntity player, Hand hand) {
        ItemStack itemHeld = player.getStackInHand(hand);
        ItemStack itemOffhand = player.getOffHandStack();

        if (!itemOffhand.isEmpty()) {
            if (hand.equals(Hand.MAIN_HAND) && !itemOffhand.isIn(CommonTags.C_TOOLS_KNIVES) && !(itemHeld.getItem() instanceof BlockItem)) {
                return ActionResult.PASS;
            }
            if (hand.equals(Hand.OFF_HAND) && itemOffhand.isIn(CommonTags.C_TOOLS_KNIVES)) {
                return ActionResult.PASS;
            }
        }
        if (itemHeld.isEmpty()) {
            return ActionResult.PASS;
        } else if (bakingMatBlockEntity.addItem(player.getAbilities().creativeMode ? itemHeld.copy() : itemHeld)) {
            world.playSound(null, bakingMatBlockEntity.getPos(), SoundEvents.BLOCK_WOOD_PLACE, SoundCategory.BLOCKS, 1.f, .8f);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof BakingMatBlockEntity) {
                ItemScatterer.spawn(world, pos, (BakingMatBlockEntity)blockEntity);
                world.updateComparators(pos,this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BakingMatBlockEntity(pos, state);
    }
}

package com.chefmoon.ubesdelight.block;


import com.chefmoon.ubesdelight.registry.DamageSourcesRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalItemTags;
import net.minecraft.block.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class KalanBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = Properties.LIT;
    public KalanBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BRICKS).luminance((state) -> {
            return Boolean.TRUE.equals(state.get(Properties.LIT)) ? 13 : 0;
        }));
        setDefaultState(((getStateManager().getDefaultState()).with(FACING, Direction.NORTH)).with(LIT, false));
    }
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!Boolean.TRUE.equals(state.get(LIT)) && this.tryLightUpByPlayerHand(state, world, pos, player, hand) == ActionResult.SUCCESS) {
            return ActionResult.SUCCESS;
        } else {
            return this.onUseByPlayerHand(state, world, pos, player, hand);
        }
    }

    protected ActionResult onUseByPlayerHand(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        return this.tryExtinguishByPlayerHand(state, world, pos, player, hand);
    }

    protected ActionResult tryLightUpByPlayerHand(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ActionResult actionResult = ActionResult.PASS;
        Random RAND = new Random();
        ItemStack stackHand = player.getStackInHand(hand);
        if (stackHand.getItem() instanceof FlintAndSteelItem) {
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, RAND.nextFloat() * 0.4F + 0.8F);
            stackHand.damage(1, player, (playerEntity) -> {
                playerEntity.sendToolBreakStatus(hand);
            });
            actionResult = ActionResult.SUCCESS;
        } else if (stackHand.getItem() instanceof FireChargeItem) {
            world.playSound(player, pos, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, (RAND.nextFloat() - RAND.nextFloat()) * 0.2F + 1.0F);
            if (!player.isCreative()) {
                stackHand.decrement(1);
            }

            actionResult = ActionResult.SUCCESS;
        }

        if (actionResult.isAccepted()) {
            world.setBlockState(pos, (BlockState)state.with(LIT, Boolean.TRUE), 11);
        }

        return actionResult;
    }
    protected ActionResult tryExtinguishByPlayerHand(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand) {
        ItemStack stackHand = player.getStackInHand(hand);
        Item usedItem = stackHand.getItem();
        if (!stackHand.isIn(ConventionalItemTags.SHOVELS) && usedItem != Items.WATER_BUCKET) {
            return ActionResult.PASS;
        } else {
            this.extinguish(state, world, pos);
            if (!player.isCreative() && usedItem == Items.WATER_BUCKET) {
                player.setStackInHand(hand, new ItemStack(Items.BUCKET));
            }

            return ActionResult.SUCCESS;
        }
    }
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(new Property[]{FACING, LIT});
    }

    public @Nullable BlockState getPlacementState(ItemPlacementContext context) {
        return (BlockState)((BlockState)this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite())).with(LIT, true);
    }

    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        boolean isLit = (Boolean)world.getBlockState(pos).get(LIT);
        if (isLit && !entity.isFireImmune() && entity instanceof LivingEntity livingEntity) {
            if (!EnchantmentHelper.hasFrostWalker(livingEntity)) {
                entity.damage(DamageSourcesRegistry.KALAN_BLOCK, 1.f);
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    /*
    @Environment(EnvType.CLIENT)
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (Boolean.TRUE.equals(state.get(KalanBlock.LIT))) {
            //TODO: Particles on 4 sides
        }
    }
    */

    private void extinguish(BlockState state, World world, BlockPos pos) {
        world.setBlockState(pos, (BlockState)state.with(LIT, false));
        double dx = (double)pos.getX() + 0.5;
        double dy = (double)pos.getY();
        double dz = (double)pos.getZ() + 0.5;
        world.playSound(dx, dy, dz, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F, false);
    }
}

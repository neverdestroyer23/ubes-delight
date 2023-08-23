package com.chefmoon.ubesdelight.block.entity.client;

import com.chefmoon.ubesdelight.block.BakingMatBlock;
import com.chefmoon.ubesdelight.block.entity.BakingMatBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class BakingMatBlockEntityRender implements BlockEntityRenderer<BakingMatBlockEntity> {
    public BakingMatBlockEntityRender(BlockEntityRendererFactory.Context context) {

    }
    @Override
    public void render(BakingMatBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        World world = MinecraftClient.getInstance().world;

        ItemStack itemStack = entity.getRenderStack();
        matrices.push();
        matrices.translate(0.25f, 0.08f, 0.25f);
        matrices.scale(0.2f, 0.2f, 0.2f);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-90));

        switch (entity.getCachedState().get(BakingMatBlock.FACING)) {
            case NORTH -> matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(180));
            case EAST -> matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(270));
            case SOUTH -> matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0));
            case WEST -> matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        }

        itemRenderer.renderItem(itemStack, ModelTransformationMode.GUI, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, world, 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}

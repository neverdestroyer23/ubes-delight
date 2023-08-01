package com.chefmoon.ubesdelight.world.feature;

import com.mojang.serialization.Codec;
import com.chefmoon.ubesdelight.world.configuration.WildCropConfiguration;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.util.FeatureContext;

public class WildCropFeature extends Feature<WildCropConfiguration> {
    public WildCropFeature(Codec<WildCropConfiguration> configCodec) {
        super(configCodec);
    }
    @Override
    public boolean generate(FeatureContext<WildCropConfiguration> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos origin = context.getOrigin();
        WildCropConfiguration config = context.getConfig();
        Random random = context.getRandom();

        int i = 0;
        int tries = config.tries();
        int xzSpread = config.xzSpread() + 1;
        int ySpread = config.ySpread() + 1;

        BlockPos.Mutable mutablePos = new BlockPos.Mutable();

        RegistryEntry<PlacedFeature> floorFeature = config.floorFeature();
        if (floorFeature != null) {
            for (int j = 0; j < tries; ++j) {
                mutablePos.set(origin,
                        random.nextInt(xzSpread) - random.nextInt(xzSpread),
                        random.nextInt(ySpread) - random.nextInt(ySpread),
                        random.nextInt(xzSpread) - random.nextInt(xzSpread));
                if (config.floorFeature().value().generate(world, context.getGenerator(), random, mutablePos)) {
                    ++i;
                }
            }
        }
        for (int k = 0; k < tries; ++k) {
            int shorterXZ = xzSpread - 2;
            mutablePos.set(origin,
                    random.nextInt(shorterXZ) - random.nextInt(shorterXZ),
                    random.nextInt(ySpread) - random.nextInt(ySpread),
                    random.nextInt(shorterXZ) - random.nextInt(shorterXZ));
            if (config.primaryFeature().value().generate(world, context.getGenerator(), random, mutablePos)) {
                ++i;
            }
        }
        for (int l = 0; l < tries; ++l) {
            mutablePos.set(origin,
                    random.nextInt(xzSpread) - random.nextInt(xzSpread),
                    random.nextInt(ySpread) - random.nextInt(ySpread),
                    random.nextInt(xzSpread) - random.nextInt(xzSpread));
            if (config.secondaryFeature().value().generate(world, context.getGenerator(), random, mutablePos)) {
                ++i;
            }
        }
        for (int m = 0; m < tries; ++m) {
            mutablePos.set(origin,
                    random.nextInt(xzSpread) - random.nextInt(xzSpread),
                    random.nextInt(ySpread) - random.nextInt(ySpread),
                    random.nextInt(xzSpread) - random.nextInt(xzSpread));
            if (config.tertiaryFeature().value().generate(world, context.getGenerator(), random, mutablePos)) {
                ++i;
            }
        }
        return i > 0;
    }
}
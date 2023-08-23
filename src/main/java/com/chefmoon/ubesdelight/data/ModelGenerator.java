package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.registry.BlocksRegistry;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        //TODO: can I get a clean blockname from the BlocksRegistry? Replace the String.
        registerCrateBlock(BlocksRegistry.UBE_CRATE, "ube", blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.GARLIC_CRATE, "garlic", blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.GINGER_CRATE, "ginger", blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.LEMONGRASS_CRATE, "lemongrass", blockStateModelGenerator);

        registerVariantCrateBlock(BlocksRegistry.UBE_JUNGLE_LOG_CRATE, "ube", "jungle_log", blockStateModelGenerator);

        registerVariantCrateBlock(BlocksRegistry.UBE_JUNGLE_CRATE, "ube", "jungle", blockStateModelGenerator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ItemsRegistry.WILD_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WILD_GARLIC.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WILD_GINGER.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WILD_LEMONGRASS.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.POISONOUS_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.GARLIC.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.GINGER.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LEMONGRASS.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LEMONGRASS_SEEDS.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.SINANGAG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.KINILAW.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LUMPIA.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.TOCINO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.CHICKEN_INASAL.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.CHICKEN_INASAL_RICE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.TOSILOG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.BANGSILOG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SISIG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.BULALO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ARROZ_CALDO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.MECHADO.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.MILK_POWDER.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.SUGAR_BROWN.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LUMPIA_WRAPPER.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.MILK_TEA_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HALO_HALO.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.GARLIC_CHOP.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.GINGER_CHOP.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.COOKIE_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.COOKIE_GINGER.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.POLVORONE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.RAW_POLVORONE_CC.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.HALO_HALO_FEAST.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.MILK_TEA_UBE_FEAST.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LUMPIA_FEAST.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.LECHE_FLAN_FEAST.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.LECHE_FLAN.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UBE_CAKE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.UBE_CAKE_SLICE.get(), Models.GENERATED);

        //itemModelGenerator.register(ItemsRegistry.BAKING_MAT.get(), Models.GENERATED);

    }

    private static void registerCrateBlock(BlocksRegistry block, String name, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(block.get(),
                (new TextureMap())
                        .put(TextureKey.SIDE, new Identifier("ubesdelight", "block/" + name + "_crate_side"))
                        .put(TextureKey.TOP, new Identifier("ubesdelight", "block/" + name + "_crate_top"))
                        .put(TextureKey.BOTTOM, new Identifier("ubesdelight", "block/crate_bottom")),
                Models.CUBE_BOTTOM_TOP);
    }

    private static void registerVariantCrateBlock(BlocksRegistry block, String name, String variant, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(block.get(),
                (new TextureMap())
                        .put(TextureKey.SIDE, new Identifier("ubesdelight", "block/" + name + "_" + variant + "_crate_side"))
                        .put(TextureKey.TOP, new Identifier("ubesdelight", "block/" + name + "_" + variant + "_crate_top"))
                        .put(TextureKey.BOTTOM, new Identifier("ubesdelight", "block/" + variant + "_crate_bottom")),
                Models.CUBE_BOTTOM_TOP);
    }
}

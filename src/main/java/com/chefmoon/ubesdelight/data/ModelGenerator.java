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

        registerCrateBlock(BlocksRegistry.UBE_CRATE, BlocksRegistry.UBE_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.GARLIC_CRATE, BlocksRegistry.GARLIC_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.GINGER_CRATE, BlocksRegistry.GINGER_CRATE.getPathName(), blockStateModelGenerator);
        registerCrateBlock(BlocksRegistry.LEMONGRASS_CRATE, BlocksRegistry.LEMONGRASS_CRATE.getPathName(), blockStateModelGenerator);

        registerVariantCrateBlock(BlocksRegistry.UBE_JUNGLE_LOG_CRATE, "ube", "jungle_log", blockStateModelGenerator);

        registerVariantCrateBlock(BlocksRegistry.UBE_JUNGLE_CRATE, "ube", "jungle", blockStateModelGenerator);

        registerFlowerPotPlant(BlocksRegistry.WILD_UBE, BlocksRegistry.POTTED_UBE, blockStateModelGenerator);
        registerFlowerPotPlant(BlocksRegistry.WILD_GARLIC, BlocksRegistry.POTTED_GARLIC, blockStateModelGenerator);
        registerFlowerPotPlant(BlocksRegistry.WILD_GINGER, BlocksRegistry.POTTED_GINGER, blockStateModelGenerator);
        blockStateModelGenerator.registerDoubleBlock(BlocksRegistry.WILD_LEMONGRASS.get(), BlockStateModelGenerator.TintType.NOT_TINTED);

        //blockStateModelGenerator.registerCrop(BlocksRegistry.UBE_CROP.get(), Properties.AGE_7, 0, 0, 1, 1, 2, 2, 2, 3);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

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

        itemModelGenerator.register(ItemsRegistry.PANDESAL.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PANDESAL_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.PANDESAL_UBE_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_STAGE3.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_STAGE3.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.ENSAYMADA_UBE_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_MUNGGO_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HOPIA_UBE_RAW.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.POLVORONE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_PINIPIG_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_UBE_STAGE2.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC_STAGE0.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC_STAGE1.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.POLVORONE_CC_STAGE2.get(), Models.GENERATED);

        //itemModelGenerator.register(ItemsRegistry.ROLLING_PIN.get(), Models.GENERATED);

    }

    private static void registerCrateBlock(BlocksRegistry block, String name, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSingleton(block.get(),
                (new TextureMap())
                        .put(TextureKey.SIDE, new Identifier("ubesdelight", "block/" + name + "_side"))
                        .put(TextureKey.TOP, new Identifier("ubesdelight", "block/" + name + "_top"))
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

    private static void registerFlowerPotPlant(BlocksRegistry plantBlock, BlocksRegistry pottedPlantBlock, BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerFlowerPotPlant(plantBlock.get(), pottedPlantBlock.get(), BlockStateModelGenerator.TintType.NOT_TINTED);
    }
}

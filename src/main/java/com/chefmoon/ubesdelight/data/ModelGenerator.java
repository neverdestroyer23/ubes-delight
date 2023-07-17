package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModelGenerator extends FabricModelProvider {
    public ModelGenerator(FabricDataOutput dataGenerator) {
        super(dataGenerator);
    }

    private static java.lang.Integer AGE_PROPERTY = 3;

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Figure out crop stuff
        //blockStateModelGenerator.registerCrop(BlocksRegistry.LEMONGRASS_CROP.get(), AGE_PROPERTY, 3,4,4,4);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        itemModelGenerator.register(ItemsRegistry.WILD_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WILD_GARLIC.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WILD_GINGER.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.WILD_LEMONGRASS.get(), Models.GENERATED);

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

        itemModelGenerator.register(ItemsRegistry.MILK_TEA_UBE.get(), Models.GENERATED);
        itemModelGenerator.register(ItemsRegistry.HALO_HALO.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.GARLIC_CLOVES.get(), Models.GENERATED);

        itemModelGenerator.register(ItemsRegistry.LECHE_FLAN.get(), Models.GENERATED);
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
    }
}

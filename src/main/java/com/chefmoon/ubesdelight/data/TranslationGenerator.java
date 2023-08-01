package com.chefmoon.ubesdelight.data;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class TranslationGenerator extends FabricLanguageProvider {
    protected TranslationGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {

        translationBuilder.add(UbesDelightMod.ITEM_GROUP, "Ube's Delight");

        translationBuilder.add(ItemsRegistry.UBE_CRATE.get(), "Ube Crate");
        translationBuilder.add(ItemsRegistry.GARLIC_CRATE.get(), "Garlic Crate");
        translationBuilder.add(ItemsRegistry.GINGER_CRATE.get(), "Ginger Crate");
        translationBuilder.add(ItemsRegistry.LEMONGRASS_CRATE.get(), "Lemongrass Crate");


        //translationBuilder.add(BlocksRegistry.WILD_UBES.get(), "Wild Ube");
        translationBuilder.add(ItemsRegistry.WILD_UBE.get(), "Wild Ube");
        translationBuilder.add(ItemsRegistry.WILD_GARLIC.get(), "Wild Garlic");
        translationBuilder.add(ItemsRegistry.WILD_GINGER.get(), "Wild Ginger");
        translationBuilder.add(ItemsRegistry.WILD_LEMONGRASS.get(), "Wild Lemongrass");

        translationBuilder.add(ItemsRegistry.SINANGAG.get(), "Sinangag");
        translationBuilder.add(ItemsRegistry.KINILAW.get(), "Kinilaw");
        translationBuilder.add(ItemsRegistry.LUMPIA.get(), "Lumpia");
        translationBuilder.add(ItemsRegistry.TOCINO.get(), "Tocino");
        translationBuilder.add(ItemsRegistry.CHICKEN_INASAL.get(), "Chicken Inasal");

        translationBuilder.add(ItemsRegistry.CHICKEN_INASAL_RICE.get(), "Chicken Inasal Plate");
        translationBuilder.add(ItemsRegistry.TOSILOG.get(), "Tosilog");
        translationBuilder.add(ItemsRegistry.BANGSILOG.get(), "Bangsilog");
        translationBuilder.add(ItemsRegistry.SISIG.get(), "Sisig");
        translationBuilder.add(ItemsRegistry.BULALO.get(), "Bulalo");
        translationBuilder.add(ItemsRegistry.ARROZ_CALDO.get(), "Arroz Caldo");
        translationBuilder.add(ItemsRegistry.MECHADO.get(), "Mechado");

        translationBuilder.add(ItemsRegistry.UBE.get(), "Ube");
        translationBuilder.add(ItemsRegistry.GARLIC.get(), "Garlic");
        translationBuilder.add(ItemsRegistry.GINGER.get(), "Ginger");
        translationBuilder.add(ItemsRegistry.LEMONGRASS.get(), "Lemongrass");
        translationBuilder.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), "Lemongrass Seeds");

        translationBuilder.add(ItemsRegistry.CONDENSED_MILK_BOTTLE.get(), "Condensed Milk Bottle");
        translationBuilder.add(ItemsRegistry.FISH_SAUCE_BOTTLE.get(), "Fish Sauce Bottle");
        translationBuilder.add(ItemsRegistry.MILK_POWDER.get(), "Milk Powder");
        translationBuilder.add(ItemsRegistry.SUGAR_BROWN.get(), "Brown Sugar");
        translationBuilder.add(ItemsRegistry.LUMPIA_WRAPPER.get(), "Lumpia Wrapper");

        translationBuilder.add(ItemsRegistry.MILK_TEA_UBE.get(), "Ube Milk Tea");
        translationBuilder.add(ItemsRegistry.HALO_HALO.get(), "Halo Halo");

        translationBuilder.add(ItemsRegistry.GARLIC_CLOVES.get(), "Garlic Cloves");

        translationBuilder.add(ItemsRegistry.LECHE_FLAN.get(), "Leche Flan");
        translationBuilder.add(ItemsRegistry.COOKIE_UBE.get(), "Ube Cookie");
        translationBuilder.add(ItemsRegistry.COOKIE_GINGER.get(), "Ginger Cookie");

        translationBuilder.add(ItemsRegistry.POLVORONE.get(), "Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_PINIPIG.get(), "Pinipig Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_UBE.get(), "Ube Polvorone");
        translationBuilder.add(ItemsRegistry.POLVORONE_CC.get(), "Cookies and Cream Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE.get(), "Raw Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_PINIPIG.get(), "Raw Pinipig Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_UBE.get(), "Raw Ube Polvorone");
        translationBuilder.add(ItemsRegistry.RAW_POLVORONE_CC.get(), "Raw Cookies and Cream Polvorone");

        translationBuilder.add(ItemsRegistry.HALO_HALO_FEAST.get(), "Halo Halo Feast");

        translationBuilder.add(ItemsRegistry.UBE_CAKE.get(), "Ube Cake");
        translationBuilder.add(ItemsRegistry.UBE_CAKE_SLICE.get(), "Ube Cake Slice");
    }
}

package com.chefmoon.ubesdelight.util.registryutil;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;

public class MiscUtil {

    public static void register() {
        registerCompostables();
    }

    private static void registerCompostables() {

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS_SEEDS.get(), .3f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC_CHOP.get(), .4f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GINGER_CHOP.get(), .4f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LUMPIA_WRAPPER.get(), .4f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_UBE.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_GARLIC.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_GINGER.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.WILD_LEMONGRASS.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.UBE.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GARLIC.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.GINGER.get(), .65f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LEMONGRASS.get(), .65f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.COOKIE_UBE.get(), .85f);
        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.COOKIE_GINGER.get(), .85f);

        CompostingChanceRegistry.INSTANCE.add(ItemsRegistry.LECHE_FLAN.get(), 1.f);

    }
}

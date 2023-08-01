package com.chefmoon.ubesdelight.util.registryutil;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;

public class TradeUtil {
    public static void register() {
        registerVillagerTradeOffers();
        registerWanderingTraderTradeOffers();
    }
    private static void registerVillagerTradeOffers() {
        //Farmer Villagers
        if (UbesDelightMod.CONFIG.isFarmersBuyUDCrops()) {
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.UBE.get(), 26),
                                16, 2, 0.05f
                        )));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GARLIC.get(), 26),
                                16, 2, 0.05f
                        )));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GINGER.get(), 26),
                                16, 2, 0.05f
                        )));
                    });
            TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER,2,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.LEMONGRASS.get(), 20),
                                16, 5, 0.05f
                        )));
                    });
        }
    }
    private static void registerWanderingTraderTradeOffers() {
        //Wandering Traders
        if (UbesDelightMod.CONFIG.isWanderingTraderSellsUDItems()) {
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.UBE.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GARLIC.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.GINGER.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
            TradeOfferHelper.registerWanderingTraderOffers(1,
                    factories -> {
                        factories.add(((entity, random) -> new TradeOffer(
                                new ItemStack(Items.EMERALD, 1),
                                new ItemStack(ItemsRegistry.LEMONGRASS_SEEDS.get(), 1),
                                1, 12, 0.05f
                        )));
                    });
        }
    }
}

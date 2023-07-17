package com.chefmoon.ubesdelight.registry;

import com.chefmoon.ubesdelight.UbesDelightMod;
import com.chefmoon.ubesdelight.item.ConsumableItem;
import com.chefmoon.ubesdelight.item.DrinkableItem;
import com.chefmoon.ubesdelight.item.ModBlockItem;
import com.chefmoon.ubesdelight.item.enumeration.FoodItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import java.util.function.Supplier;

import static com.chefmoon.ubesdelight.item.ModItemSettings.base;
import static com.chefmoon.ubesdelight.item.ModItemSettings.food;


public enum ItemsRegistry {


    //Vegetable Crates
    UBE_CRATE("ube_crate", () -> new ModBlockItem((BlocksRegistry.UBE_CRATE.get()))),
    GARLIC_CRATE("garlic_crate", () -> new ModBlockItem((BlocksRegistry.GARLIC_CRATE.get()))),
    GINGER_CRATE("ginger_crate", () -> new ModBlockItem((BlocksRegistry.GINGER_CRATE.get()))),
    LEMONGRASS_CRATE("lemongrass_crate", () -> new ModBlockItem((BlocksRegistry.LEMONGRASS_CRATE.get()))),

    //Wild Vegetables
    WILD_UBE("wild_ube", () -> new ModBlockItem(BlocksRegistry.WILD_UBE.get())),
    WILD_GARLIC("wild_garlic", () -> new ModBlockItem(BlocksRegistry.WILD_GARLIC.get())),
    WILD_GINGER("wild_ginger", () -> new ModBlockItem(BlocksRegistry.WILD_GINGER.get())),
    WILD_LEMONGRASS("wild_lemongrass", () -> new ModBlockItem(BlocksRegistry.WILD_LEMONGRASS.get())),

    //Items
    UBE("ube", () -> new AliasedBlockItem(BlocksRegistry.UBE_CROP.get(), food(FoodItem.UBE))),
    GARLIC("garlic", () -> new AliasedBlockItem(BlocksRegistry.GARLIC_CROP.get(), food(FoodItem.GARLIC))),
    GINGER("ginger", () -> new AliasedBlockItem(BlocksRegistry.GINGER_CROP.get(), food(FoodItem.GINGER))),
    LEMONGRASS("lemongrass", () -> new Item(food(FoodItem.LEMONGRASS))),
    LEMONGRASS_SEEDS("lemongrass_seeds", () -> new AliasedBlockItem(BlocksRegistry.LEMONGRASS_CROP.get(), base())),

    //Finger Foods
    SINANGAG("sinangag", () -> new ConsumableItem(food(FoodItem.SINANGAG, Items.BOWL, 16))),
    KINILAW("kinilaw", () -> new ConsumableItem(food(FoodItem.KINILAW, Items.BOWL, 16))),
    LUMPIA("lumpia", () -> new ConsumableItem(food(FoodItem.LUMPIA,null, 32))),
    TOCINO("tocino", () -> new ConsumableItem(food(FoodItem.TOCINO,null, 32))),
    CHICKEN_INASAL("chicken_inasal", () -> new ConsumableItem(food(FoodItem.CHICKEN_INASAL,null, 32))),

    //Meals
    CHICKEN_INASAL_RICE("chicken_inasal_rice", () -> new ConsumableItem(food(FoodItem.CHICKEN_INASAL_RICE, Items.BOWL, 16))),
    TOSILOG("tosilog", () -> new ConsumableItem(food(FoodItem.TOSILOG, Items.BOWL, 16))),
    BANGSILOG("bangsilog", () -> new ConsumableItem(food(FoodItem.BANGSILOG, Items.BOWL, 16))),
    SISIG("sisig", () -> new ConsumableItem(food(FoodItem.SISIG, Items.BOWL, 16))),
    BULALO("bulalo", () -> new ConsumableItem(food(FoodItem.BULALO, Items.BOWL, 16))),
    ARROZ_CALDO("arroz_caldo", () -> new ConsumableItem(food(FoodItem.ARROZ_CALDO, Items.BOWL, 16))),
    MECHADO("mechado", () -> new ConsumableItem(food(FoodItem.MECHADO, Items.BOWL, 16))),

    //Ingredients
    CONDENSED_MILK_BOTTLE("condensed_milk_bottle", () -> new DrinkableItem(food(FoodItem.CONDENSED_MILK_BOTTLE, Items.GLASS_BOTTLE, 16), true)),
    FISH_SAUCE_BOTTLE("fish_sauce_bottle", () -> new DrinkableItem(food(FoodItem.FISH_SAUCE_BOTTLE, Items.GLASS_BOTTLE, 16), true)),
    MILK_POWDER("milk_powder", () -> new Item(base())),
    SUGAR_BROWN("sugar_brown", () -> new Item(base())),
    //Drinks
    MILK_TEA_UBE("milk_tea_ube", () -> new DrinkableItem(food(FoodItem.MILK_TEA_UBE, Items.GLASS_BOTTLE, 16), true)),
    HALO_HALO("halo_halo", () -> new DrinkableItem(food(FoodItem.HALO_HALO, Items.GLASS_BOTTLE, 16), true)),

    //Partial Vegetables
    GARLIC_CLOVES("garlic_cloves", () -> new Item(food(FoodItem.GARLIC_CLOVES))),

    //Sweets
    LECHE_FLAN("leche_flan", () -> new Item(food(FoodItem.LECHE_FLAN))),
    COOKIE_UBE("cookie_ube", () -> new Item(food(FoodItem.COOKIES))),
    COOKIE_GINGER("cookie_ginger", () -> new Item(food(FoodItem.COOKIES))),
    POLVORONE("polvorone", () -> new Item(food(FoodItem.POLVORONE))),
    POLVORONE_PINIPIG("polvorone_pinipig", () -> new Item(food(FoodItem.POLVORONE))),
    POLVORONE_UBE("polvorone_ube", () -> new Item(food(FoodItem.POLVORONE))),
    POLVORONE_CC("polvorone_cc", () -> new Item(food(FoodItem.POLVORONE))),
    RAW_POLVORONE("raw_polvorone", () -> new Item(base())),
    RAW_POLVORONE_PINIPIG("raw_polvorone_pinipig", () -> new Item(base())),
    RAW_POLVORONE_UBE("raw_polvorone_ube", () -> new Item(base())),
    RAW_POLVORONE_CC("raw_polvorone_cc", () -> new Item(base()));



    private final String pathName;
    private final Supplier<Item> itemSupplier;
    private final Integer burnTime;
    private Item item;

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier) {
        this(pathName, itemSupplier, null);
    }

    ItemsRegistry(String pathName, Supplier<Item> itemSupplier, Integer burnTime) {
        this.pathName = pathName;
        this.itemSupplier = itemSupplier;
        this.burnTime = burnTime;
    }

    public static void registerAll() {
        for (ItemsRegistry value : values()) {
            Registry.register(Registries.ITEM, new Identifier(UbesDelightMod.MOD_ID, value.pathName), value.get());
            ItemGroupEvents.modifyEntriesEvent(UbesDelightMod.ITEM_GROUP).register(entries -> entries.add(value.get()));
            if (value.burnTime != null && value.burnTime > 0) {
                FuelRegistry.INSTANCE.add(value.get(), value.burnTime);
            }
        }
    }

    public Item get() {
        if (item == null) {
            item = itemSupplier.get();
        }
        return item;
    }

    public String getId() {
        return Registries.ITEM.getId(get()).toString();
    }
}

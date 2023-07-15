package com.chefmoon.ubesdelight.mixin;

import com.chefmoon.ubesdelight.registry.ItemsRegistry;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ChickenEntity.class)
public abstract class ChickenEntityBreedingMixin {

    @Inject(method = "isBreedingItem", at = @At("TAIL"), cancellable = true)
    private void isBreedingItem(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (!Boolean.TRUE.equals(cir.getReturnValue())) {
            cir.setReturnValue(Ingredient.ofItems(
                    ItemsRegistry.LEMONGRASS_SEEDS.get()).test(stack));
        }
    }

}
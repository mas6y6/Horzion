package com.mas6y6.horzion

import net.minecraft.world.item.Tier
import net.minecraft.world.item.crafting.Ingredient
import com.mas6y6.horzion.Horzion

object AiriumToolMaterial : Tier {
    override fun getLevel(): Int = 3 // Mining level (like iron, diamond, etc.)
    override fun getUses(): Int = 1561 // Durability
    override fun getSpeed(): Float = 8.0f // Mining speed
    override fun getAttackDamageBonus(): Float = 3.0f // Extra damage
    override fun getEnchantmentValue(): Int = 10 // Enchantability
    override fun getRepairIngredient(): Ingredient = Ingredient.of(Horzion.RAW_AIRIUM.get()) // Repair item
}

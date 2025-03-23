package com.mas6y6.horzion

import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.SwordItem
import net.minecraft.world.item.Tier
import net.minecraft.world.level.Level
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.Entity
import net.minecraftforge.registries.RegistryObject

class Excalibur(
    tier: Tier, 
    attackDamage: Float, 
    attackSpeed: Float, 
    properties: Properties) : 
    SwordItem(tier, attackDamage.toInt(), attackSpeed, properties)
{
    override fun hurtEnemy(stack:ItemStack,
    target:LivingEntity,
    attacker:LivingEntity):Boolean {
        target.kill()
        return super.hurtEnemy(stack, target, attacker)
    }
}
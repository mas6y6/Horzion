package com.mas6y6.horzion

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.ModEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

@Mod("horzion")
class MainMod {
    init {
        // Registering the block & item registration methods
        val modEventBus: ModEventBus = MinecraftForge.EVENT_BUS
        modEventBus.addListener(ModBlocks::registerBlockItems)
    }
}


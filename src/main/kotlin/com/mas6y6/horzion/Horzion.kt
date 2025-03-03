package com.mas6y6.horzion

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext

@Mod("horzion")
class MainMod {
    private val BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "horzion")
    private val ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "horzion")

    init {
        val modEventBus: IEventBus = FMLJavaModLoadingContext.get().modEventBus
        
        modEventBus.addListener(this::commonSetup)

        BLOCKS.register(modEventBus)
        ITEMS.register(modEventBus)

        MinecraftForge.EVENT_BUS.register(this)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        println("Above the Horzions is ready")
    }

    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        println("We hope you enjoy!")
    }

    @SubscribeEvent
    fun onSetup(event: FMLCommonSetupEvent) {
        println("Setup completed")
    }
}


package com.mas6y6.horzion

import com.mas6y6.horzion.Blocks.AiriumOre
import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegisterEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Material
@Mod("horzion")
class Horzion {
    public val BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "horzion")
    public val ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "horzion")

    init {
        val modEventBus: IEventBus = FMLJavaModLoadingContext.get().modEventBus

        modEventBus.addListener(this::commonSetup)

        BLOCKS.register(modEventBus)
        ITEMS.register(modEventBus)


        BlockRegisteries.register()
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
"""
    @SubscribeEvent
    fun register(event: RegisterEvent) {
        event.register(ForgeRegistries.Keys.BLOCKS,
            { helper:RegistryObject ->
                helper.register
            }, p2)
    }
"""
}


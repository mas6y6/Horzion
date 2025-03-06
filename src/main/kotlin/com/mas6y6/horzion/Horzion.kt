package com.mas6y6.horzion

import net.minecraftforge.api.distmarker.Dist
import net.minecraftforge.common.MinecraftForge
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import net.minecraftforge.registries.RegisterEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.Output
import net.minecraft.world.level.block.Block
import net.minecraft.core.registries.Registries
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.SoundType
import net.minecraft.resources.ResourceLocation
import net.minecraft.network.chat.Component
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import com.mojang.logging.LogUtils;

@Mod("horzion")
class Horzion {
    companion object {
        val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, "horzion")
        val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, "horzion")
        val LOGGER = LogUtils.getLogger();
        val CREATIVE_TABS: DeferredRegister<CreativeModeTab> =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "horzion")

        val AIRIUM_ORE: RegistryObject<Block> = Horzion.BLOCKS.register("airium_ore") {
            Block(BlockBehaviour.Properties.of()
                .strength(1.5f, 1.5f)
                .sound(SoundType.STONE)
                .lightLevel { 0 }
            )
        }

        val AIRIUM_ORE_ITEM: RegistryObject<Item> = ITEMS.register("airium_ore") {
            BlockItem(AIRIUM_ORE.get(), Item.Properties())
        }

        val RAW_AIRIUM: RegistryObject<Item> = ITEMS.register("raw_airium") {
            Item(Item.Properties())
        }

        val AIRIUM_INGOT: RegistryObject<Item> = ITEMS.register("airium_ingot") {
            Item(Item.Properties())
        }

        // Creative Tab - Avoid direct calls to `.get()` during registration
        val HORZION_TAB: RegistryObject<CreativeModeTab> = CREATIVE_TABS.register("horzion_tab") {
            CreativeModeTab.builder()
                .icon { AIRIUM_INGOT.get().defaultInstance } // Lazy evaluation
                .title(Component.translatable("itemGroup.horzion_tab")) // Use translatable for localization
                .displayItems { _, output ->
                    output.accept(AIRIUM_ORE_ITEM.get()) // Use BlockItem
                    output.accept(RAW_AIRIUM.get())
                    output.accept(AIRIUM_INGOT.get())
                }
                .build()
        }

    init {
        try {
            LOGGER.info("Horzion Mod Initialized")

            val modEventBus: IEventBus = FMLJavaModLoadingContext.get().modEventBus
            LOGGER.info("Mod Event Bus initialized")

            BLOCKS.register(modEventBus)
            LOGGER.info("Registered BLOCKS DeferredRegister")

            ITEMS.register(modEventBus)
            LOGGER.info("Registered ITEMS DeferredRegister")

            CREATIVE_TABS.register(modEventBus)
            LOGGER.info("Registered CREATIVE menu")

            modEventBus.addListener(this::commonSetup)
            MinecraftForge.EVENT_BUS.register(this)
            LOGGER.info("Listeners registered")
        } catch (e: Exception) {
            LOGGER.error("Error during initialization: ${e.message}", e)
        }
    }

    fun commonSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("Horzion commonSetup event called")
    }

    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        LOGGER.info("Horzion onServerStarting called")
    }

    @SubscribeEvent
    fun onSetup(event: FMLCommonSetupEvent) {
        LOGGER.info("Horzion onSetup called")
        } 
    }

    @SubscribeEvent
    fun onRegister(event: RegisterEvent) {
        if (event.registryKey == Registries.CREATIVE_MODE_TAB) {
            event.register(Registries.CREATIVE_MODE_TAB, ResourceLocation("horzion", "horzion_tab")) {
                HORZION_TAB.get()
            }
        }
    }
}
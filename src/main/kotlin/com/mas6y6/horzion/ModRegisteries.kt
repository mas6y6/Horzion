package com.mas6y6.horzion

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.item.Item
import net.minecraftforge.registries.RegistryObject
import net.minecraft.resources.ResourceLocation
import net.minecraft.core.registries.Registries
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraft.network.chat.Component
import com.mas6y6.horzion.Horzion

object ModRegistries {
    // Register Blocks
    val AIRIUM_ORE: RegistryObject<Block> = Horzion.BLOCKS.register("airium_ore") {
        Block(BlockBehaviour.Properties.of()
            .strength(4.0f, 5.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)
            .lightLevel { 0 }
        )
    }

    // Register BlockItem separately
    val AIRIUM_ORE_ITEM: RegistryObject<Item> = Horzion.ITEMS.register("airium_ore") {
        BlockItem(AIRIUM_ORE.get(), Item.Properties())
    }

    // Register Items
    val RAW_AIRIUM: RegistryObject<Item> = Horzion.ITEMS.register("raw_airium") {
        Item(Item.Properties())
    }

    val AIRIUM_INGOT: RegistryObject<Item> = Horzion.ITEMS.register("airium_ingot") {
        Item(Item.Properties())
    }

    // Creative Tab - Avoid direct calls to `.get()` during registration
    val HORZION_TAB: RegistryObject<CreativeModeTab> = Horzion.CREATIVE_TABS.register("horzion_tab") {
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

    // Ensure proper order of registration
    fun register(modEventBus: IEventBus) {
        Horzion.BLOCKS.register(modEventBus)
        Horzion.ITEMS.register(modEventBus)
        Horzion.CREATIVE_TABS.register(modEventBus)
    }
}

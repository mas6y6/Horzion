package com.mas6y6.horzion

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.item.Item
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.resources.ResourceLocation
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.eventbus.api.IEventBus


object ModRegisteries {
    val AIRIUM_ORE: RegistryObject<Block> = Horzion.BLOCKS.register("airium_ore") {
        Block(
            BlockBehaviour.Properties.of(Blocks.STONE)  // Corrected import for Material
                .strength(3.0f)
                .requiresCorrectToolForDrops()
        )
    }
    
    val AIRIUM_ORE_ITEM: RegistryObject<Item> = Horzion.ITEMS.register("airium_ore") {
        BlockItem(AIRIUM_ORE.get(), Item.Properties())
    }

    public val HORZION_TAB: CreativeModeTab = CreativeModeTab.builder()
        .icon { AIRIUM_ORE.get() }
        .title { "Horzion" }
        .build()

    // Register your loot table in a JSON file in resources folder
    // LootTableManager.registerLootTable(AIRIUM_ORE.get(), ResourceLocation("horzion", "blocks/airium_ore")) // This line is not needed
    fun register(modEventBus: IEventBus) {
        modEventBus.addListener(this::onRegister)

        CreativeModeTabEvent.REGISTER.register { event ->
            event.addTab(HORZION_TAB)
        }
    }
}

package com.mas6y6.horzion

import net.minecraft.resources.ResourceLocation
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object ModSounds {
    val SOUND_EVENTS: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, "horzion")

    val SPAMTRACK: RegistryObject<SoundEvent> = SOUND_EVENTS.register("bigshot") {
        SoundEvent.createVariableRangeEvent(ResourceLocation("horzion", "bigshot"))
    }
}
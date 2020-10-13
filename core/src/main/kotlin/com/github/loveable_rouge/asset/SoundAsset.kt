package com.github.loveable_rouge.asset

import com.github.loveable_rouge.asset.BaseSoundAsset

enum class SoundAsset(private val asset: BaseSoundAsset) {
    EXPLOSION(BaseSoundAsset(fileName = "explosion_sound.wav")),
    SHOT(BaseSoundAsset(fileName = "laser_shot.wav")),
    POWER_UP(BaseSoundAsset(fileName = "power_up_sound.wav"));

    val descriptor
        get() = asset.descriptor
}

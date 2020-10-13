package com.github.loveable_rouge.asset

enum class TextureAtlasAsset(private val asset: BaseAtlasAsset) {
    TEXTURE_ATLAS(BaseAtlasAsset(fileName = "textures.atlas"));

    val descriptor
        get() = asset.descriptor
}

package com.github.loveable_rouge.asset

import com.github.loveable_rouge.asset.TextureAtlasAsset.*

enum class BitmapFontAsset(private val asset: BaseBitmapFontAsset) {
    ROGUE_FONT_B(BaseBitmapFontAsset(fileName = "RogueFont_B.fnt", fontAtlasName = TEXTURE_ATLAS.descriptor.fileName)),
    ROGUE_FONT_G(BaseBitmapFontAsset(fileName = "RogueFont_G.fnt", fontAtlasName = TEXTURE_ATLAS.descriptor.fileName)),
    ROGUE_FONT_O(BaseBitmapFontAsset(fileName = "RogueFont_O.fnt", fontAtlasName = TEXTURE_ATLAS.descriptor.fileName)),
    ROGUE_FONT_W(BaseBitmapFontAsset(fileName = "RogueFont_W.fnt", fontAtlasName = TEXTURE_ATLAS.descriptor.fileName));

    val descriptor
        get() = asset.descriptor
}

package com.github.loveable_rouge.ecs.system

import com.badlogic.ashley.core.EntitySystem
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.github.loveable_rouge.asset.BitmapFontAsset.ROGUE_FONT_O
import com.github.loveable_rouge.asset.SpriteCache
import ktx.assets.async.AssetStorage
import ktx.graphics.use

class UIRenderSystem(
    private val viewport: FitViewport,
    private val batch: Batch,
    private val assetStorage: AssetStorage,
    private val spriteCache: SpriteCache) : EntitySystem() {


    override fun update(deltaTime: Float) {
        viewport.apply()
        batch.use(viewport.camera.combined) {
            spriteCache.getSprite("UI_frame").draw(it)
            assetStorage[ROGUE_FONT_O.descriptor].draw(it, "Hello, world!", 10f,36f)
        }
    }
}

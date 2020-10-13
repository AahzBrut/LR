package com.github.loveable_rouge

import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.github.loveable_rouge.asset.BitmapFontAsset
import com.github.loveable_rouge.asset.SpriteCache
import com.github.loveable_rouge.asset.TextureAtlasAsset
import com.github.loveable_rouge.ecs.initEngine
import com.github.loveable_rouge.screen.BaseScreen
import com.github.loveable_rouge.screen.GameScreen
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import ktx.app.KtxGame
import ktx.assets.async.AssetStorage
import ktx.async.KtxAsync
import ktx.async.newAsyncContext
import ktx.collections.gdxArrayOf
import ktx.log.logger

private val LOG = logger<LRGame>()

class LRGame : KtxGame<BaseScreen>() {

    val gameViewport = FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT)

    val uiViewport = FitViewport(WORLD_WIDTH, WORLD_HEIGHT)

    val assetStorage by lazy {
        KtxAsync.initiate()
        AssetStorage(newAsyncContext(ASSET_STORAGE_LOADER_THREAD_NUMBER, "AssetStorage-Thread"))
    }

    val graphicsAtlas by lazy { assetStorage[TextureAtlasAsset.TEXTURE_ATLAS.descriptor] }

    val spriteCache by lazy {
        SpriteCache(graphicsAtlas)
    }

    val batch: Batch by lazy { SpriteBatch() }

    val engine by lazy { initEngine(this) }

    override fun create() {
        // Gdx.app.logLevel = Application.LOG_DEBUG
        val assetLoaders = gdxArrayOf(
            TextureAtlasAsset.values().map { assetStorage.loadAsync(it.descriptor) },
            BitmapFontAsset.values().map { assetStorage.loadAsync(it.descriptor) }
        ).flatten()

        KtxAsync.launch {
            assetLoaders.joinAll()
            addScreen(GameScreen(this@LRGame))
            setScreen<GameScreen>()
        }
    }

    override fun dispose() {
        super.dispose()
        assetStorage.dispose()
        batch.dispose()
    }
}
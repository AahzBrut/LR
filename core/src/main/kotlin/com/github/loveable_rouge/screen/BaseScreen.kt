package com.github.loveable_rouge.screen

import com.badlogic.gdx.utils.viewport.Viewport
import com.github.loveable_rouge.LRGame
import ktx.app.KtxScreen

abstract class BaseScreen(
    protected val game: LRGame,
    protected val gameViewport: Viewport = game.gameViewport,
    protected val uiViewport: Viewport = game.uiViewport,
) : KtxScreen {

    override fun resize(width: Int, height: Int) {
        gameViewport.update(width, height, true)
        uiViewport.update(width, height, true)
    }
}
package com.github.loveable_rouge.screen

import com.badlogic.ashley.core.Engine
import com.github.loveable_rouge.LRGame

class GameScreen(
    game: LRGame,
    private val engine: Engine = game.engine
): BaseScreen(game) {

    override fun render(delta: Float) {
        engine.update(delta)
    }
}
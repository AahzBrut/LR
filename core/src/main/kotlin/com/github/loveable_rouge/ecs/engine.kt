package com.github.loveable_rouge.ecs

import com.badlogic.ashley.core.Engine
import com.badlogic.ashley.core.PooledEngine
import com.github.loveable_rouge.LRGame
import com.github.loveable_rouge.ecs.system.PlayerInputSystem
import com.github.loveable_rouge.ecs.system.UIRenderSystem

fun initEngine(game: LRGame): Engine =
    PooledEngine(1000, 10000, 5000, 50000).apply {
        addSystem(PlayerInputSystem(game.gameViewport))
        addSystem(UIRenderSystem(game.uiViewport,game.batch, game.assetStorage, game.spriteCache))
    }

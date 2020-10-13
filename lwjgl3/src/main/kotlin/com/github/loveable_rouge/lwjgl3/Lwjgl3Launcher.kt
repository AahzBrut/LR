package com.github.loveable_rouge.lwjgl3

import kotlin.jvm.JvmStatic
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.github.loveable_rouge.LRGame
import com.github.loveable_rouge.SCREEN_HEIGHT
import com.github.loveable_rouge.SCREEN_WIDTH

/** Launches the desktop (LWJGL3) application.  */
object Lwjgl3Launcher {

    @JvmStatic
    fun main(args: Array<String>) {

        Lwjgl3Application(
            LRGame(),
            Lwjgl3ApplicationConfiguration().apply {
                setTitle("Lovable Rogue")
                setWindowedMode(SCREEN_WIDTH.toInt(), SCREEN_HEIGHT.toInt())
                setResizable(false)
                setWindowIcon("libgdx128.png", "libgdx64.png", "libgdx32.png", "libgdx16.png")
            })
    }
}
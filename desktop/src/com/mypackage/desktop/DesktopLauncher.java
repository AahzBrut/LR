package com.mypackage.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.mypackage.MyGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.width = 750;
		config.height = 800;
		config.x = -1;
		config.y = -1;
		config.title = "Lovable Rogue";
		config.resizable = false;

		TexturePacker.Settings settings = new TexturePacker.Settings();
		settings.pot = true;
		settings.fast = true;
		settings.combineSubdirectories = true;
		settings.paddingX = 1;
		settings.paddingY = 1;
		settings.edgePadding = true;

		//TexturePacker.process(settings, "core/assets/Tilesets", "core/assets", "textures");

		new LwjglApplication(new MyGame(), config);
	}
}

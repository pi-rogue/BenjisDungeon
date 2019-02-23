package com.pirogue.game.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.pirogue.game.Constants;
import com.pirogue.game.PiRogue;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		Constants.RESOLUTION = (float)LwjglApplicationConfiguration.getDesktopDisplayMode().height/(float)LwjglApplicationConfiguration.getDesktopDisplayMode().width; // On définit la résolution
		Constants.CAMERA_HEIGHT = (int)(Constants.RESOLUTION * Constants.CAMERA_WIDTH); // C'est pas beau de faire ça ici mais la flemme
		config.title = "Pi Rogue";
		config.width = Constants.CAMERA_WIDTH;
		config.height = Constants.CAMERA_HEIGHT;
		config.fullscreen = true;
		config.addIcon("icon_32x32.png", Files.FileType.Internal);

		new LwjglApplication(new PiRogue(), config); // Démarrer le jeu
	}
}

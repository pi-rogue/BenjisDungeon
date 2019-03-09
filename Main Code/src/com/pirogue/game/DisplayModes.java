package com.pirogue.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class DisplayModes {

	/*
	 *
	 * C'est un bout de code qui permet de récupérer toutes les résolutions disponibles, on s'en servira surement plus tard
	 * 
	 * Si vous voulez tester y'a juste à ajouter new DisplayModes(); à n'importe quel endroit du code
	 * 
	 */
	
	
	public DisplayModes() {
		DisplayMode[] modes;
		try {
			modes = Display.getAvailableDisplayModes();
	        for (int i=0;i<modes.length;i++) {
	            DisplayMode current = modes[i];
	            System.out.println(current.getWidth() + "x" + current.getHeight() + "x" +
	                                current.getBitsPerPixel() + " " + current.getFrequency() + "Hz");
	        }
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
}

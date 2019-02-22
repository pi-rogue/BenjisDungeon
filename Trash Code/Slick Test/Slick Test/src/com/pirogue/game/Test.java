package com.pirogue.game;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Test extends BasicGame {

	private GameContainer container;

	public Test() {
		super("Test Game");
	}

	
	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath()); // A laisser, pour qu'il trouve les libraries

		new AppGameContainer(new Test(), 640, 480, false).start(); // Demarre le jeu avec une fenêtre de 640x480
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
	}
	
	public void keyReleased(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			container.exit();
		}
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}
}

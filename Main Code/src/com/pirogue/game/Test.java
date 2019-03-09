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
	private Dungeon dungeon;
	private Hero hero;

	public Test() {
		super("Test Game");
	}

	
	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath()); // A laisser, pour qu'il trouve les libraries
		AppGameContainer application = new AppGameContainer(new Test(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false); // Demarre le jeu avec une fenêtre de 640x480
		application.setFullscreen(Constants.FULLSCREEN);
		application.start();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Constants.container = container; // On le met ici pour pouvoir y accéder de partout
		this.container = container;
		container.setShowFPS(Constants.SHOW_FPS);
		container.setVSync(Constants.VERTICAL_SYNC);
		container.setMaximumLogicUpdateInterval(Constants.DELTA_MAX);

		this.dungeon = new Dungeon("assets/map/tiles/spritesheet.png", "assets/map/tiles/collide.png");
		Constants.dungeon = this.dungeon;
		this.dungeon.spawnHero();
	}
	
	public void keyReleased(int key, char c) {
		if (key == Constants.KEY_Exit) {
			container.exit();
		}
	}
	
	private String arrowsDirection() {
		Input input = this.container.getInput();

		String directionV = ""; // verticale
		String directionH = ""; // horizontale
		if (input.isKeyDown(Constants.KEY_Up)) {directionV += "N";}
		if (input.isKeyDown(Constants.KEY_Down)) {directionV += "S";}
		if (input.isKeyDown(Constants.KEY_Right)) {directionH += "E";}
		if (input.isKeyDown(Constants.KEY_Left)) {directionH += "O";}		
		if (directionV.length()>1) directionV = "";
		if (directionH.length()>1) directionH = "";
		return directionV + directionH;
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		dungeon.render(g);
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		dungeon.hero.update(container, delta);
		
		if (container.getInput().isKeyPressed(Constants.KEY_ViewCollisions)) {
			dungeon.getCurrentFloor().vision = !dungeon.getCurrentFloor().vision;
		}
		
		String arrowsDir = arrowsDirection();
		if (arrowsDir.equals("")) dungeon.hero.setMoving(false); // Pour le momentum on a juste à ajouter une petite variable ici
		else dungeon.hero.setMoving(true);                       // qui s'incrémente et on rajoute dans la condition : compteur>10
		
		switch (arrowsDir) {
		case "N" : dungeon.hero.setDirection(0); break;
		case "NE": dungeon.hero.setDirection(1); break;
		case "E" : dungeon.hero.setDirection(2); break;
		case "SE": dungeon.hero.setDirection(3); break;
		case "S" : dungeon.hero.setDirection(4); break;
		case "SO": dungeon.hero.setDirection(5); break;
		case "O" : dungeon.hero.setDirection(6); break;
		case "NO": dungeon.hero.setDirection(7); break;
		}		
	}
}

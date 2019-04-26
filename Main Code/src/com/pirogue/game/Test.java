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

	public Test() {
		super("Test Game");
	}

	
	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath()); // A laisser, pour qu'il trouve les libraries
		AppGameContainer application = new AppGameContainer(new Test(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false); // Demarre le jeu avec une fenêtre de 640x480
		application.setFullscreen(Constants.FULLSCREEN);
		application.setTargetFrameRate(Constants.FPS_MAX);
		application.start();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		Constants.init();
		Constants.container = container; // On le met ici pour pouvoir y accéder de partout
		this.container = container;
		container.setShowFPS(Constants.SHOW_FPS);
		container.setVSync(Constants.VERTICAL_SYNC);
		container.setMaximumLogicUpdateInterval(Constants.DELTA_MAX);
		this.dungeon = new Dungeon();
		Constants.dungeon = this.dungeon;
		this.dungeon.spawnHero();
	}
	
	public void keyReleased(int key, char c) {
		if (key == Constants.KEY_Exit) {
			if (dungeon.hero.inInventory())	dungeon.hero.toggleInventory();
			else container.exit();
		}
	}
	
	public void keyPressed(int key, char c) {
		if (key == Constants.KEY_DebugView) {
			dungeon.getCurrentFloor().toggleDebugView();
		}
		else if (key == Constants.KEY_Inventory) {
			dungeon.hero.toggleInventory();
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
		for(int i=0; i<Constants.nbMob; i++) {
			dungeon.getCurrentFloor().tabMob[i].pathfinding(this.dungeon.hero.x,this.dungeon.hero.y);
			dungeon.getCurrentFloor().tabMob[i].update(container, delta);
		}
				
		String arrowsDir = arrowsDirection();
		if (arrowsDir.equals(""))
			dungeon.hero.setMoving(-1);
		else { // Pour le momentum on a juste à ajouter dans cette ligne un elseif avec la condition compteur>10
			switch (arrowsDir) {
			case "N" : dungeon.hero.setMoving(0); break;
			case "NE": dungeon.hero.setMoving(1); break;
			case "E" : dungeon.hero.setMoving(2); break;
			case "SE": dungeon.hero.setMoving(3); break;
			case "S" : dungeon.hero.setMoving(4); break;
			case "SO": dungeon.hero.setMoving(5); break;
			case "O" : dungeon.hero.setMoving(6); break;
			case "NO": dungeon.hero.setMoving(7); break;
			}
		}
	}
	
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		Constants.mouseX = newx;
		Constants.mouseY = newy;

	}
	
	public void mousePressed(int button, int x, int y) {
		if (button==0) Constants.mousePressed = true;
	}
	
	public void mouseReleased(int button, int x, int y) {
		if (button==0) Constants.mousePressed = false;
	}
}

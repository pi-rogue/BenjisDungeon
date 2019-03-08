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
		AppGameContainer application = new AppGameContainer(new Test(), 640, 480, false); // Demarre le jeu avec une fenêtre de 640x480
		//application.setFullscreen(true);
		application.start();
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		this.container = container;
		//container.setShowFPS(false);
		container.setVSync(true); // Askip ça évite des problèmes d'affichage (synchronisation verticale)
		container.setMaximumLogicUpdateInterval(20); // Force delta <= 20 (permet de ne pas (trop) traverser les murs si il y a un freeze)

		this.dungeon = new Dungeon(150, 150, "assets/map/tiles/spritesheet.png", "assets/map/tiles/collide.png", 32, container);
	}
	
	public void keyReleased(int key, char c) {
		if (key == Input.KEY_ESCAPE) {
			container.exit();
		}
	}
	
	private String arrowsDirection() {
		Input input = this.container.getInput();

		String directionV = ""; // verticale
		String directionH = ""; // horizontale
		if (input.isKeyDown(Input.KEY_UP)) {directionV += "N";}
		if (input.isKeyDown(Input.KEY_DOWN)) {directionV += "S";}
		if (input.isKeyDown(Input.KEY_RIGHT)) {directionH += "E";}
		if (input.isKeyDown(Input.KEY_LEFT)) {directionH += "O";}		
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

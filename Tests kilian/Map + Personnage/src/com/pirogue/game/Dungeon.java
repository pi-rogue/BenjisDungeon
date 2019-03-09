package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Dungeon {

	protected ArrayList<Map> floors = new ArrayList<Map>();
	public Hero hero;
	private int width, height;
	private SpriteSheet spritesheet;
	private SpriteSheet collidesheet;
	public GameContainer container;
	public int currentFloor;
	
	public Dungeon(int width, int height, String sprSheet, String colSheet, int textureSize, GameContainer container) throws SlickException {
		this.width = width;
		this.height = height;
		this.container = container;
		this.spritesheet = new SpriteSheet(sprSheet, textureSize, textureSize);
		this.collidesheet = new SpriteSheet(colSheet, textureSize, textureSize);
		this.currentFloor = 0;
		
		generateFloor();
		
		Tile Sol = new Tile(spritesheet.getSprite(3, 0),collidesheet.getSprite(3,0));
		int spawnX, spawnY;
		do {
			spawnX = 25 + (int)(Math.random() * ((125 - 25) + 1));
			spawnY = 25 + (int)(Math.random() * ((125 - 25) + 1));
		} while(this.getCurrentFloor().Blocks[spawnX][spawnY].equals(Sol));
		this.hero = new Hero(spawnX*32, spawnY*32, new SpriteSheet("assets/sprites/test.png", 32, 32), this);
		
		// Je pense que le mieux serait finalement de générer dès le début
		// un nombre fixe d'étages random entre 7 - 10 par exemple avec un boss au dernier
	}
	
	public void generateFloor() {
		floors.add(new Map(width, height, spritesheet, collidesheet));
	}
	
	public Map getCurrentFloor() {
		return floors.get(currentFloor);
	}
	
	public void render(Graphics g) {
		floors.get(currentFloor).render(g, hero.getX(), hero.getY()); // J'ai jouit en écrivant cette ligne c'est trop beau
		hero.render(g);
	}	
}

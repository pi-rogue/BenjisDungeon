package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Dungeon {

	protected ArrayList<Map> floors = new ArrayList<Map>();
	public Hero hero;
	private int floorWidth, floorHeight;
	private SpriteSheet spritesheet;
	private SpriteSheet collidesheet;
	public GameContainer container;
	public int currentFloor;
	private int blockSize;
	
	public Dungeon(String sprSheet, String colSheet) throws SlickException {
		this.floorWidth = Constants.mapWidth;
		this.floorHeight = Constants.mapHeight;
		this.container = Constants.container;
		this.spritesheet = new SpriteSheet(sprSheet, Constants.blockSize, Constants.blockSize);
		this.collidesheet = new SpriteSheet(colSheet, Constants.blockSize, Constants.blockSize);
		this.currentFloor = 0;
		this.blockSize = Constants.blockSize;
		
		generateFloor();
		
		// Je pense que le mieux serait finalement de générer dès le début
		// un nombre fixe d'étages random entre 7 - 10 par exemple avec un boss au dernier
	}
	
	public void generateFloor() {
		floors.add(new Map(floorWidth, floorHeight, spritesheet, collidesheet));
	}

	public void spawnHero() throws SlickException {
		this.hero = new Hero(this.getCurrentFloor().spawnX*blockSize, this.getCurrentFloor().spawnY*blockSize,
				new SpriteSheet("assets/sprites/test.png", blockSize, blockSize));

		// Affichage du bloc de spawn //
		this.getCurrentFloor().Blocks[getCurrentFloor().spawnX][getCurrentFloor().spawnY] = new Tile(collidesheet.getSprite(3, 1), collidesheet.getSprite(2, 0));

	}
	
	public Map getCurrentFloor() {
		return floors.get(currentFloor);
	}
	
	public void render(Graphics g) {
		getCurrentFloor().render(g, hero.getX() - Constants.SCREEN_WIDTH/2, hero.getY() - Constants.SCREEN_HEIGHT/2);
		hero.render(g);
	}	
}

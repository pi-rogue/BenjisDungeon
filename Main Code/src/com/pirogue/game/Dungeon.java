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
	public GameContainer container;
	public int currentFloor;
	
	public Dungeon() {
		this.floorWidth = Constants.mapWidth;
		this.floorHeight = Constants.mapHeight;
		this.container = Constants.container;
		this.currentFloor = 0;
		
		generateFloor();
		
		// Je pense que le mieux serait finalement de générer dès le début
		// un nombre fixe d'étages random entre 7 - 10 par exemple avec un boss au dernier
	}
	
	public void generateFloor() {
		floors.add(new Map(floorWidth, floorHeight));
	}

	public void spawnHero() throws SlickException {
		this.hero = new Hero(this.getCurrentFloor().spawnX*Constants.blockSize, this.getCurrentFloor().spawnY*Constants.blockSize,
				new SpriteSheet("assets/sprites/test.png", Constants.blockSize, Constants.blockSize));

		// Affichage du bloc de spawn //
//		this.getCurrentFloor().Blocks[getCurrentFloor().spawnX][getCurrentFloor().spawnY] = new Tile(collidesheet.getSprite(3, 1), collidesheet.getSprite(2, 0));

	}
	
	public Map getCurrentFloor() {
		return floors.get(currentFloor);
	}
	
	public void render(Graphics g) {
		getCurrentFloor().render(g, hero.getX() - Constants.SCREEN_WIDTH/2, hero.getY() - Constants.SCREEN_HEIGHT/2);
		hero.render(g);
	}	
}

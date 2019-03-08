package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Dungeon {

	protected ArrayList<Map> floors = new ArrayList<Map>();
	private int width, height;
	private SpriteSheet spritesheet;
	private SpriteSheet collidesheet;
	private int currentFloor;
	
	public Dungeon(int width, int height, String sprSheet, String colSheet, int textureSize) throws SlickException {
		this.width = width;
		this.height = height;
		this.spritesheet = new SpriteSheet(sprSheet, textureSize, textureSize);
		this.collidesheet = new SpriteSheet(colSheet, textureSize, textureSize);
		this.currentFloor = 0;
		
		generateFloor();
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
		floors.get(currentFloor).render(g); // J'ai jouit en écrivant cette ligne c'est trop beau
	}	
}

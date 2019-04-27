package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.pirogue.entity.Hero;
import com.pirogue.entity.classes.Rogue;

public class Dungeon {

	protected ArrayList<Map> floors = new ArrayList<Map>();
	public Hero hero;
	private int floorWidth, floorHeight;
	public GameContainer container;
	public int currentFloor;
	
	public Dungeon() throws SlickException {
		this.floorWidth = Constants.mapWidth;
		this.floorHeight = Constants.mapHeight;
		this.container = Constants.container;
		this.currentFloor = 0;
		
		generateFloor(Constants.nbFloors);
		
		// Je pense que le mieux serait finalement de générer dès le début
		// un nombre fixe d'étages random entre 7 - 10 par exemple avec un boss au dernier
	}
	
	public void generateFloor(int j) throws SlickException {
		for(int i=0; i<j; i++) {
			floors.add(new Map(floorWidth, floorHeight));
			getCurrentFloor().spawnMob(Constants.nbMob);
		}
	}

	public void spawnHero() throws SlickException {
		this.hero = new Rogue(this.getCurrentFloor().spawnX, this.getCurrentFloor().spawnY);
	}
	
	public Map getCurrentFloor() {
		return floors.get(currentFloor);
	}
	
	public void render(Graphics g) {
		getCurrentFloor().render(g, hero.getX() - Constants.SCREEN_WIDTH/2, hero.getY() - Constants.SCREEN_HEIGHT/2);
		getCurrentFloor().renderMobs(g, hero.getX(), hero.getY());
		hero.render(g); // Render du héros en dernier pour qu'il soit par dessus tout
	}	
}

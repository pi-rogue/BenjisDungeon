package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.pirogue.entity.Hero;
import com.pirogue.entity.classes.Rogue;

public class Dungeon {

	protected ArrayList<Map> floors = new ArrayList<Map>(); // Contient tous les étages du donjon
	public Hero hero;
	public int currentFloor;
	
	public Dungeon() throws SlickException {
		this.currentFloor = 0;
		
		generateFloors(Constants.nbFloors);
		
		// Le mieux serait de générer dès le début un nombre fixe d'étages random,
		// entre 7 - 10 par exemple avec un boss au dernier.
	}
	
	public void generateFloors(int j) throws SlickException {
		// Génère j nouveaux étages
		for(int i=0; i<j; i++) {
			floors.add(new Map(Constants.mapWidth, Constants.mapHeight));
			this.floors.get(i).spawnEntity(Constants.nbStairs, "Stairs");
			this.floors.get(i).spawnEntity(Constants.nbChest, "Chest");
			this.floors.get(i).spawnEntity((int) (Constants.nbMob*0.9), "Slime");
			this.floors.get(i).spawnEntity((int) (Constants.nbMob*0.1), "FireGhost");
		}
	}

	public void spawnHero() throws SlickException {
		int X = this.getCurrentFloor().spawnX*Constants.blockSize+Constants.blockSize/2;
		int Y = this.getCurrentFloor().spawnY*Constants.blockSize+Constants.blockSize/2;
		this.hero = new Rogue(X, Y); // Les coordonnées de spawn sont données par la Map
	}
	
	public Map getCurrentFloor() {
		return floors.get(currentFloor);
	}
	
	public void render(Graphics g) {
		getCurrentFloor().render(g, hero.x, hero.y);
		hero.render(g); // Render du héros en dernier pour qu'il soit par dessus tout
	}	
}

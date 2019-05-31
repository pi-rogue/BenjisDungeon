package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import com.pirogue.entity.Hero;
import com.pirogue.entity.classes.Rogue;

public class Dungeon {

	protected ArrayList<Map> floors = new ArrayList<Map>(); // Contient tous les �tages du donjon
	public Hero hero;
	public int currentFloor;
	
	public Dungeon() throws SlickException {
		this.currentFloor = 0;
		
		generateFloors(Constants.nbFloors);
		
		// Le mieux serait de g�n�rer d�s le d�but un nombre fixe d'�tages random,
		// entre 7 - 10 par exemple avec un boss au dernier.
	}
	
	public void generateFloors(int j) throws SlickException {
		// G�n�re j nouveaux �tages
		for(int i=0; i<j; i++) {
			floors.add(new Map(Constants.mapWidth, Constants.mapHeight));
			getCurrentFloor().spawnMob(Constants.nbMob);
		}
	}

	public void spawnHero() throws SlickException {
		this.hero = new Rogue(this.getCurrentFloor().spawnX, this.getCurrentFloor().spawnY); // Les coordonn�es de spawn sont donn�es par la Map
	}
	
	public Map getCurrentFloor() {
		return floors.get(currentFloor);
	}
	
	public void render(Graphics g) {
		getCurrentFloor().render(g, hero.x, hero.y);
		hero.render(g); // Render du h�ros en dernier pour qu'il soit par dessus tout
	}	
}

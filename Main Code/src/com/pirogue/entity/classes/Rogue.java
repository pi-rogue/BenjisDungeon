package com.pirogue.entity.classes;

import org.newdawn.slick.SlickException;

import com.pirogue.entity.Hero;
import com.pirogue.items.Daggers;

public class Rogue extends Hero {

	public Rogue(int x, int y) throws SlickException {
		super(x, y, "rogue");
		this.inventory.equipment[5] = new Daggers("bloody_daggers"); // Commence avec une arme dans sa main droite
		refreshAnimations();
	}
}
package com.pirogue.entity.classes;

import org.newdawn.slick.SlickException;

import com.pirogue.entity.Hero;
import com.pirogue.items.Daggers;


public class Rogue extends Hero {

	public Rogue(int x, int y) throws SlickException {
		super(x, y, "rogue");
		this.inventory.equipment[5] = new Daggers("Bloody_Daggers_common_"+Integer.toString(1),40800+1,"Bloody_Daggers",8,4.2,0,0,1,0,0,1);; // Commence avec une arme dans sa main droite
		refreshAnimations();
	}
}
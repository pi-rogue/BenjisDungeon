package com.pirogue.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Daggers extends Item {
	
	public Daggers(String ID) throws SlickException {
		super(ID, "weapon", new Image("assets/items/" + ID + ".png"));
	}
	
}

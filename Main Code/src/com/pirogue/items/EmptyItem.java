package com.pirogue.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EmptyItem extends Item {

	public EmptyItem() throws SlickException {
		super("EmptyItem","empty", "none", new Image("assets/items/empty.png"),0,0,0,0,0,0,0,0,0);
	}
}

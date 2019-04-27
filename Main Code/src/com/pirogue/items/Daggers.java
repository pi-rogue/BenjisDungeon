package com.pirogue.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.pirogue.game.Constants;

public class Daggers extends Item {

	public Daggers() throws SlickException {
		super("bloodyDaggers", new Image("assets/items/bloodyDaggers.png"), Constants.animations.get("rogue bloody_daggers"));
	}
}

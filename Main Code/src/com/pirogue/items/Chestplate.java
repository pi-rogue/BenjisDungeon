package com.pirogue.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Chestplate extends Item {
	
	public Chestplate(String name,int ID,String acces,double health, double health_level,int level) throws SlickException
	{
		super(name,String.format("%08d", ID), "armor", new Image("assets/items/" + acces + ".png"),0,0,0,0,0,0,health,health_level,level);
		
	}

}

package com.pirogue.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Swords extends Item{
	
	public Swords(String name,int ID,String acces,double damage,double damage_level,double power,double power_level,double attack_speed,double health ,double health_level,int level) throws SlickException {
		
		super(name,String.format("%08d", ID), "weapon", new Image("assets/items/" + acces + ".png"),32,damage,damage_level,power,power_level,attack_speed,health,health_level,level);
		
}
}
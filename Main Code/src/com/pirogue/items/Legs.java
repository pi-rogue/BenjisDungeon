package com.pirogue.items;

public class Legs extends Item{
	
	public Legs(String name,int ID,String acces,double health, double health_level)
	{
		super(name,String.format("%08d", ID), "armor", acces,0,0,0,0,0,0,health,health_level);
		
	}

}

package com.pirogue.items;

public class Feet extends Item{
	
	public Feet(String name,int ID,String acces,double health, double health_level,int level)
	{
		super(name,String.format("%08d", ID), "armor", acces,0,0,0,0,0,0,health,health_level,level);
		
	}

}

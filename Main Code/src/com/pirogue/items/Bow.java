package com.pirogue.items;

public  class Bow extends Item{
	
	public Bow(String name,int ID,String acces,double damage,double damage_level,double power,double power_level,double attack_speed,double health ,double health_level,int level) {
		
		super(name,String.format("%08d", ID), "weapon", acces,300,damage,damage_level,power,power_level,attack_speed,health,health_level,level);
		
}
}

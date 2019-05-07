package com.pirogue.items;

import org.newdawn.slick.Image;

public abstract class Item {

	private String ID;
	public String name;
	public String rarity;
	public String type;
	private Image texture;
	public double power;
	public double power_level;
	public double damage;
	public double damage_level;
	public double health;
	public double health_level;	
	public int level;
	public double attack_speed;
	//abstract void damage(); 
	public int range;
	
	//abstract void spell();

	public Item(String name,String ID, String type,  Image texture,int range,double damage,double damage_level,double power,double power_level,double attack_speed,double heal ,double health_level,int level) {
		this.name=name;
		this.ID = ID;
		this.type = type;
		this.texture = texture;
		this.damage = damage + (damage_level * (level-1));
		this.damage_level = damage_level;
		this.power = power + (power_level * (level-1));
		this.power_level = power_level;
		this.attack_speed = attack_speed;
		this.health = health + (health_level * (level-1));
		this.health_level = health_level;
		this.level=level;
		
	}
	
	public String getID() {
		return ID;
	}

	public Image getTexture() {
		return texture;
	}
}

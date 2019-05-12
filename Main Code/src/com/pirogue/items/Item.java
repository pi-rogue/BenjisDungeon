package com.pirogue.items;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Item {

	private String ID, name, rarity, type, acces;
	private Image texture;
	public double power, power_level,
				  damage, damage_level,
				  health, health_level,
				  attack_speed;
	public int level, range;
	
	//abstract void damage(); 
	//abstract void spell();
	
	public Item(String name, String ID, String type, String acces,int range,double damage,double damage_level,double power,double power_level,double attack_speed,double health ,double health_level,int level) {
		this.name=name;
		this.ID = ID;
		this.type = type;
		this.acces = acces;
		try {
			this.texture = new Image("assets/items/" + acces + ".png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
		this.damage = damage + (damage_level * (level-1));
		this.damage_level = damage_level;
		this.power = power + (power_level * (level-1));
		this.power_level = power_level;
		this.attack_speed = attack_speed;
		this.health = health + (health_level * (level-1));
		this.health_level = health_level;
		this.level=level;
		
	}
	
	
	// -- Getters -- //
	
	public String getID() {
		return ID;
	}

	public Image getTexture() {
		return texture;
	}
	
	public String getAcces() {
		return acces;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}
	
	public String getRarity() {
		return rarity;
	}
	
	public int getRange() {
		return range;
	}
	
	public double getDamage() {
		return damage;
	}
	
	public double getDamage_level() {
		return damage_level;
	}
	
	public double getPower() {
		return power;
	}
	
	public double getPower_level() {
		return power_level;
	}
	
	public double getHealth() {
		return health;
	}
	
	public double getHealth_level() {
		return health_level;
	}
	
	public int getLevel() {
		return level;
	}
	
	public double getAttack_speed() {
		return attack_speed;
	}
}

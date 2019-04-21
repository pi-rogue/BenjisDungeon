package com.pirogue.items;

import org.newdawn.slick.Image;

public abstract class Item {

	private String ID;
	private String name;
	private String rarity;
	private Image texture; 
		
	public Item(String ID, Image texture) {
		this.ID = ID;
		this.texture = texture;
	}
	
	public String getID() {
		return ID;
	}

	public Image getTexture() {
		return texture;
	}
}

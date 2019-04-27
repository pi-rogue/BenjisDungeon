package com.pirogue.items;

import org.newdawn.slick.Image;

public abstract class Item {

	private String ID;
	public String name;
	public String rarity;
	public String type;
	private Image texture;

	public Item(String ID, String type,  Image texture) {
		this.ID = ID;
		this.type = type;
		this.texture = texture;
	}
	
	public String getID() {
		return ID;
	}

	public Image getTexture() {
		return texture;
	}
}

package com.pirogue.items;

import org.newdawn.slick.Image;

import com.pirogue.game.Animation;

public abstract class Item {

	private String ID;
	private String name;
	private String rarity;
	private Image texture;
	private Animation[] animation;

	public Item(String ID, Image texture, Animation[] animation) {
		this.ID = ID;
		this.texture = texture;
		this.animation = animation;
	}
	
	public String getID() {
		return ID;
	}

	public Image getTexture() {
		return texture;
	}

	public Animation[] getAnimation() {
		return animation;
	}
}

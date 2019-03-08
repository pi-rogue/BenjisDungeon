package com.pirogue.game;

import org.newdawn.slick.Image;

public class Tile {
	private Image texture; // Je pense qu'en faisant comme ça il peut y avoir des problèmes de perf sur
	private Image collide; // des grandes maps, si c'est le cas on peut le régler easy j'ai déjà une idée

	public Tile() {
		this.texture = null;
		this.collide = null;
	}
	
	public Tile(Image texture, Image collide) {
		this.texture = texture;
		this.collide = collide;
	}
	
	public Image getTexture() {
		return texture;
	}
	
	public Image getCollide() {
		return collide;
	}
}

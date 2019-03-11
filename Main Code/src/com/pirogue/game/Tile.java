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
	
	public boolean equals(Tile tile) {
		if (this.texture==null && tile.getTexture()==null && this.collide==null && tile.getCollide()==null) return true;
		if (this.texture==null && tile.getTexture()==null) return this.collide.equals(tile.getCollide());
		if (this.collide==null && tile.getCollide()==null) return this.texture.equals(tile.getTexture());
		if (this.texture==null || tile.getTexture()==null || this.collide==null || tile.getCollide()==null) return false; // On veut éviter les NullPointerException
		return this.texture.equals(tile.getTexture()) && this.collide.equals(tile.getCollide());
	}
}

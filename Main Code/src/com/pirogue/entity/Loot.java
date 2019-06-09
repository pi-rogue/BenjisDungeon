package com.pirogue.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.pirogue.game.Constants;
import com.pirogue.items.EmptyItem;
import com.pirogue.items.Item;

public class Loot extends Entity{
	
	private Item loot;
	protected int distX, distY;

	public Loot(int x, int y) {
		super(x, y);
		random();
		this.collisionsEnabled=false;
	}

	public Loot(int x, int y, int ID) {
		super(x, y);
		this.loot = Constants.items.get(ID);
		this.collisionsEnabled=false;
	}

	
	public void render(Graphics g, int offsetX, int offsetY) {
		float X = this.x - offsetX + (Constants.SCREEN_WIDTH-Constants.blockSize)/2;  // Coordonnées du coin supérieur gauche (en considérant que l'entité a une longueur 
		float Y = this.y - offsetY + (Constants.SCREEN_HEIGHT-Constants.blockSize)/2; // et largeur d'une case entière et pas -2, ce qui permet de ne pas décaler l'image)
		g.drawImage(this.loot.getTexture(),X,Y);
		// Affichage de la hitbox //
		if (Constants.debug) {
			g.setColor(new Color(1f, 1f, 1f));
			g.drawRect(this.x-offsetX +(Constants.SCREEN_WIDTH-this.width)/2 , this.y-offsetY +(Constants.SCREEN_HEIGHT-this.height)/2, this.width, this.height);
		}
	}	
	
	@Override
	protected void refreshAnimations() {}

	@Override
	public void dealDamages() {}

	@Override
	public void hurt(int damages) {/* Les items de prennent pas de dégâts*/}
	
	@Override 
	public void update(int delta) {
		distX = this.x - Constants.dungeon.hero.x; // Distance qui separe le hero du mob en x
		distY = this.y - Constants.dungeon.hero.y; // Pareil en y

		if((distX*distX+distY*distY) <= Constants.blockSize*Constants.blockSize/4) {
			int n=6;
			while((!(Constants.dungeon.hero.inventory.objects[n] instanceof EmptyItem))) {
				n++;
				if (n==26)
					return;
			}
			Constants.dungeon.hero.inventory.objects[n] = this.loot;
			this.vanished=true;
		}
	}
	
	public void random() {
		/* Définit l'ID de l'item à faire spawn de façon aléatoire */
		int random;
		do {
			random = (int) (Math.random() * (2000));
		} while(!(Constants.items.get(random) instanceof Item));
		this.loot = Constants.items.get(random);
	}


	@Override
	protected void updateFacing() {/* Les items n'ont pas de facing */}
}
	


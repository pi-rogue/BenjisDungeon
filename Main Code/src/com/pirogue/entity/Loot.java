package com.pirogue.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import com.pirogue.game.Constants;
import com.pirogue.items.EmptyItem;
import com.pirogue.items.Item;
import com.pirogue.items.List;

public class Loot extends Entity{
	
	private int random;
	Item loot;
	List list = new List();
	protected int distX, distY;

	public Loot(int x, int y) {
		
		super(x, y);
		random();
		this.collisionsEnabled=false;
		refreshAnimations();
		// TODO Auto-generated constructor stub
	}
	
	
	public void render(Graphics g, int offsetX, int offsetY) {
		float X = this.x - offsetX + (Constants.SCREEN_WIDTH-Constants.blockSize)/2;  // Coordonnées du coin supérieur gauche (en considérant que l'entité a une longueur 
		float Y = this.y - offsetY + (Constants.SCREEN_HEIGHT-Constants.blockSize)/2; // et largeur d'une case entière et pas -2, ce qui permet de ne pas décaler l'image)
		g.drawImage(list.Items[random].getTexture(),X,Y);
		// Affichage de la hitbox //
				if (Constants.debug) {
					g.setColor(new Color(1f, 1f, 1f));
					g.drawRect(this.x-offsetX +(Constants.SCREEN_WIDTH-this.width)/2 , this.y-offsetY +(Constants.SCREEN_HEIGHT-this.height)/2, this.width, this.height);
				}
	}	
	
	@Override
	protected void refreshAnimations() {
		
	}

	@Override
	public void dealDamages() {}

	@Override
	public void hurt(int damages) {		
	}
	@Override 
	public void update(int delta) {
			
		distX = this.x - Constants.dungeon.hero.x;//la distance qui separe le hero du mob en x
		distY = this.y - Constants.dungeon.hero.y;//pareil en y

		if((distX*distX+distY*distY) <= 300 ) {
			
			
			int n=6;
			while((!(Constants.dungeon.hero.inventory.objects[n] instanceof EmptyItem))) {
				n++;
				if (n==26)
					return;
				}
				
			
			
			
			Constants.dungeon.hero.inventory.objects[n] = list.Items[random];
			this.vanished=true;}
					
		}
	
	public void random() {
		
		
		do {
			random = (int) (Math.random() * (200000));
		}while(!(list.Items[random] instanceof Item  ));
		
	}


	@Override
	protected void updateFacing() {
		// TODO Auto-generated method stub
		
	}}
	


package com.pirogue.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.pirogue.game.Constants;
import com.pirogue.game.util.Animations;

public abstract class Projectile extends Entity {

	private Image body;
	protected float angle;
	
	public Projectile(int x, int y, float angle) {
		super(x, y);
		this.velocity = 0.1f;
		this.angle = angle;
		
		refreshAnimations();
	}

	@Override
	public void render(Graphics g, int offsetX, int offsetY) {
		float X = this.x-offsetX + (Constants.SCREEN_WIDTH-Constants.blockSize)/2;  // Coordonnées du coin supérieur gauche (en considérant que l'entité a une longueur 
		float Y = this.y-offsetY + (Constants.SCREEN_HEIGHT-Constants.blockSize)/2; // et largeur d'une case entière et pas -2, ce qui permet de ne pas décaler l'image)
		// Affichage de la hitbox //
		if (Constants.debug) {
			g.setColor(new Color(1f, 1f, 1f));
			g.drawRect(this.x-offsetX +(Constants.SCREEN_WIDTH-this.width)/2 , this.y-offsetY +(Constants.SCREEN_HEIGHT-this.height)/2, this.width, this.height);
		}
		
		g.drawImage(body, X, Y);
	}
	
	@Override
	protected void refreshAnimations() {
		Animations tmp = new Animations(Constants.animations.get("projectiles fireball"));
		this.body = tmp.get(0).getImage(0);
		body.rotate(this.angle);
	}
	
	public void update(int delta) {
		int movement = Constants.randomRound(velocity * delta); // Calcul du déplacement, en réduisant la vitesse si l'entité est entrain de glisser
		int futureX = Constants.randomRound(x + movement * (float)Math.cos(angle));
		int futureY = Constants.randomRound(y + movement * (float)Math.sin(angle));
		
		// Si on sort de la map ben en fait non (au cas où)
		if (futureX<0) futureX=0;
		if (futureY<0) futureY=0;
		if (futureX>Constants.mapWidth*Constants.blockSize-width) futureX=Constants.mapWidth*Constants.blockSize-width;
		if (futureY>Constants.mapHeight*Constants.blockSize-height) futureY=Constants.mapHeight*Constants.blockSize-height;
		
		this.x = futureX;
		this.y = futureY;
	}

	@Override
	protected void updateFacing() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dealDamages() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hurt(int damages) {
		// TODO Auto-generated method stub
		
	}
	
}

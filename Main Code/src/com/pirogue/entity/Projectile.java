package com.pirogue.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.pirogue.game.Constants;
import com.pirogue.game.util.Animations;

public abstract class Projectile extends Entity {

	private Image body;
	protected float angle; // En radians
	
	public Projectile(int x, int y, float angle) {
		super(x, y);
		this.angle = angle;
		this.collisionsEnabled = false;
		
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
		this.body = tmp.get(0).getImage(0).getFlippedCopy(false, false); // Pour avoir une nouvelle image pour chaque projectile on utilise une petite astuce
		body.rotate(this.angle * (float)(180/Math.PI)); // Rotation en degrés
	}
	
	public void update(int delta) {
		if (!isDead) {
			int dX = (int) Math.round((velocity * delta * Math.cos(angle)));
			int dY = (int) Math.round((velocity * delta * Math.sin(angle)));
			int futureX = x + dX;
			int futureY = y + dY;
		
			// Si on sort de la map ben en fait non (au cas où)
			if (futureX<0) futureX=0;
			if (futureY<0) futureY=0;
			if (futureX>Constants.mapWidth*Constants.blockSize-width) futureX=Constants.mapWidth*Constants.blockSize-width;
			if (futureY>Constants.mapHeight*Constants.blockSize-height) futureY=Constants.mapHeight*Constants.blockSize-height;
		
			dealDamages();
			
			boolean corners[] = {true, true, true, true}; // Pour simplifier on teste tous les coins
			if (isColliding(corners, futureX, futureY).equals("wall") || isColliding(corners, futureX, futureY).equals("void")) {
				this.isDead = true;
				this.vanished = true; // TODO: Ajouter une animation de disparition
			}
			else {
				this.x = futureX;
				this.y = futureY;
			}
		}
	}

	@Override
	protected void updateFacing() {}

	@Override
	public void dealDamages() {
		if (Math.sqrt(Math.pow(Constants.dungeon.hero.x-this.x, 2)+Math.pow(Constants.dungeon.hero.y-this.y, 2))<Constants.blockSize) {
			Constants.dungeon.hero.hurt(this.damages);
			this.isDead = true;
			this.vanished = true; // TODO: Ajouter une animation de disparition
		}
	}

	@Override
	public void hurt(int damages) {}
}

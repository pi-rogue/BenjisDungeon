package com.pirogue.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Hero {
	
	private float velocity = 0.5f; // Je sais pas vous mais chez moi ça fait n'importe quoi dès qu'on passe en dessous de 0.5f jsp pourquoi
	private int x,y, width,height, direction, spriteDir;
	private boolean moving = false;
	private Animation[][] animations; // Tableau 2D parce que pour chaque direction on a deux anims (en déplacement ou non)
	private Map map;
	private Dungeon dungeon;
	
	public Hero(int x, int y, SpriteSheet spriteSheet, Dungeon dungeon) {
		this.map = dungeon.getCurrentFloor();
		this.dungeon = dungeon;
		this.x = x;
		this.y = y;
		int IMGwidth = spriteSheet.getWidth();
		int IMGheight = spriteSheet.getHeight();
		this.width = spriteSheet.getSprite(0, 0).getWidth();
		this.height = (int) spriteSheet.getSprite(0,0).getHeight();
			
		animations = new Animation[IMGheight/width][2];
		for (int n=0; n<IMGheight/height; n++) {
			Animation anim = new Animation();
			Animation animMoving = new Animation();
			
			anim.addFrame(spriteSheet.getSprite(0, n), 100); // Image quand le perso est immobile
			
			for (int i=1; i<IMGwidth/width; i++) {
				animMoving.addFrame(spriteSheet.getSprite(i, n), 100); // Images quand le perso se déplace
			}
			
			Animation[] tmp = {anim, animMoving};
			animations[n] = tmp;
		}		
	}
	
	public void render(Graphics g) {
		g.drawAnimation(animations[direction][moving ? 1:0], dungeon.container.getWidth()/2-width/2, dungeon.container.getHeight()/2-height/2);
	}

	public void update(GameContainer container, int delta) {
		if (moving) {
			float futureX = x;
			float futureY = y;
			
			switch (direction) {
			case 0:	futureY -= velocity * delta; break;                               // N
			case 2:	futureX += velocity * delta; break;                               // E
			case 4:	futureY += velocity * delta; break;                               // S
			case 6:	futureX -= velocity * delta; break;                               // O
			case 1:	futureX += velocity * delta; futureY -= velocity * delta; break;  // NE
			case 3:	futureX += velocity * delta; futureY += velocity * delta; break;  // SE
			case 5:	futureX -= velocity * delta; futureY += velocity * delta; break;  // SO
			case 7:	futureX -= velocity * delta; futureY -= velocity * delta; break;  // NO
			}

			// Si on sort de la map ben en fait non
			if (futureX<0) futureX=0;
			if (futureY<0) futureY=0;
			if (futureX>map.width*map.textureSize-width) futureX=map.width*map.textureSize-width;
			if (futureY>map.height*map.textureSize-height) futureY=map.height*map.textureSize-height;

			// Vérification des collisions
			Image tile = map.getCollideImage((int)(futureX/width), (int)(futureY/height));
			if (tile != null) {  // TODO prendre en compte la taille du personnage (et pas juste le coin haut gauche)
				Color color = tile.getColor(((int)futureX) % width, ((int)futureY) % height);
				if (color.getRed()==255) {
					this.x = (int) futureX;
					this.y = (int) futureY;
				}
			}
			else { // A enlever plus tard, on n'est pas censés pourvoir se déplacer sur des cases de vide
				this.x = (int) futureX;
				this.y = (int) futureY;
			}
		}
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
}

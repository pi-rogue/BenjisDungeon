package com.pirogue.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.tiled.TiledMap;

public class Hero {
	
	private float velocity = 0.5f;
	private int x,y, width,height, direction;
	private boolean moving = false;
	private Animation[][] animations;
	private TiledMap map;
	
	public Hero(int x, int y, SpriteSheet spriteSheet, TiledMap map) {
		this.map = map;
		this.x = x;
		this.y = y;
		int IMGwidth = spriteSheet.getWidth();
		this.width = spriteSheet.getSprite(0, 0).getWidth();
		int IMGheight = spriteSheet.getHeight();
		this.height = (int) spriteSheet.getSprite(0,0).getHeight();
			
		animations = new Animation[IMGheight/width][2];
		for (int n=0; n<IMGheight/height; n++) {
			Animation anim = new Animation();
			Animation animMoving = new Animation();
			
			anim.addFrame(spriteSheet.getSprite(0, n), 100); // Image quand le perso est immobile
			
			for (int i=1; i<IMGwidth/width; i++) {
				animMoving.addFrame(spriteSheet.getSprite(i, n), 100);
			}
			
			Animation[] tmp = {anim, animMoving};
			animations[n] = tmp;
		}		
	}
	
	public void render(GameContainer container, Graphics g) {
		g.drawAnimation(animations[direction][moving ? 1:0], x, y);
	}

	public void update(GameContainer container, int delta) {
		if (moving) {
			float futureX = x;
			float futureY = y;
			
			switch (direction) {
			case 0:	futureY -= velocity * delta; break;                             // N
			case 1:	futureX += velocity * delta; futureY -= velocity * delta; break;     // NE
			case 2:	futureX += velocity * delta; break;                             // E
			case 3:	futureX += velocity * delta; futureY += velocity * delta; break;     // SE
			case 4:	futureY += velocity * delta; break;                             // S
			case 5:	futureX -= velocity * delta; futureY += velocity * delta; break;     // SO
			case 6:	futureX -= velocity * delta; break;                             // O
			case 7:	futureX -= velocity * delta; futureY -= velocity * delta; break;     // NO
			}
			
			Image tile = map.getTileImage((int)(futureX/width),
										  (int)(futureY/height),
											map.getLayerIndex("collide"));
			Color color = tile.getColor(((int)futureX) % width, ((int)futureY) % height);
			if (color.getBlue()!=0) {  // TODO prendre en compte la taille du personnage (et pas juste le coin haut gauche)
				this.x = (int) futureX;
				this.y = (int) futureY;
			}
		}
		
		// Si on sort de la map ben en fait non
		if (x<0) x=0;
		if (y<0) y=0;
		if (x>container.getWidth()-width) x=container.getWidth()-width;
		if (y>container.getHeight()-height) y=container.getHeight()-height;		
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	
}

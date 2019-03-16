package com.pirogue.mob;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import com.pirogue.game.Constants;

public class Mob {
	
	protected int posX=0, posY=0;
	protected Animation[][] animations;
	protected boolean moving = false;
	protected int direction;
	
	public Mob(int x, int y) throws SlickException {
		this.posX = x*64;
		this.posY = y*64;
		SpriteSheet spriteSheet = new SpriteSheet(Constants.mobSprite, Constants.blockSize, Constants.blockSize);
		animations = new Animation[spriteSheet.getHeight()/Constants.blockSize][spriteSheet.getWidth()/Constants.blockSize];
		for (int n=0; n<spriteSheet.getHeight()/Constants.blockSize; n++) {
			Animation anim = new Animation();
			Animation animMoving = new Animation();
			
			anim.addFrame(spriteSheet.getSprite(0, n), 100);
			
			for (int i=1; i<spriteSheet.getWidth()/Constants.blockSize; i++) {
				animMoving.addFrame(spriteSheet.getSprite(i, n), 100);
			}
			
			Animation[] tmp = {anim, animMoving};
			animations[n] = tmp;
		}
	}

	public void render(Graphics g) {
		g.drawAnimation(animations[direction][moving ? 1:0], (Constants.SCREEN_WIDTH-Constants.blockSize)/2, (Constants.SCREEN_HEIGHT-Constants.blockSize)/2);
	}
	
	public void pathfind() {
		
	}
	
	public void aggro() {
		
	}
	
	public void attack() {
		
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public int getX() {
		return this.posX;
	}

	public int getY() {
		return this.posY;
	}
}

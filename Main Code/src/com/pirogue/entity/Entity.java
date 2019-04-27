package com.pirogue.entity;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import com.pirogue.game.Animation;
import com.pirogue.game.Constants;

public abstract class Entity {

	protected float velocity = 0.5f; // Je sais pas vous mais chez moi ça fait n'importe quoi dès qu'on passe en dessous de 0.5f jsp pourquoi
	public int x,y, width,height;
	protected int facing;
	protected int moving = -1;
	protected Animation[] restAnims;
	protected Animation[] movingAnims;
	protected boolean isColliding = false;

	public Entity(int x, int y) {
		this.x = x*Constants.blockSize;
		this.y = y*Constants.blockSize;
		this.width = Constants.blockSize-4;
		this.height = Constants.blockSize-4;
		this.restAnims = Constants.animations.get("default");
		this.movingAnims = Constants.animations.get("default_moving");
	}

	public void render(Graphics g, int offsetX, int offsetY) {
		if (Constants.debug) {
			g.setColor(new Color(1f, 1f, 1f));
			g.drawRect(this.x-offsetX + Constants.SCREEN_WIDTH/2, this.y-offsetY + Constants.SCREEN_HEIGHT/2, this.width, this.height);
		}
		try {
			if (moving==-1)
				g.drawAnimation(restAnims[facing], this.x-offsetX + Constants.SCREEN_WIDTH/2, this.y-offsetY + Constants.SCREEN_HEIGHT/2);
			else
				g.drawAnimation(movingAnims[facing], this.x-offsetX + Constants.SCREEN_WIDTH/2, this.y-offsetY + Constants.SCREEN_HEIGHT/2);
		}
		catch (java.lang.NullPointerException e, java.lang.IndexOutOfBoundsException f) {
			g.drawAnimation(Constants.animations.get("missing")[0], this.x-offsetX + Constants.SCREEN_WIDTH/2, this.y-offsetY + Constants.SCREEN_HEIGHT/2);
		}
	}

	public void update(GameContainer container, int delta) {
		updateFacing();

		if (moving!=-1) {
			float futureX = x;
			float futureY = y;

			switch (moving) {
			case 0:	futureY -= velocity * delta; break;                               // N
			case 2:	futureX += velocity * delta; break;                               // E
			case 4:	futureY += velocity * delta; break;                               // S
			case 6:	futureX -= velocity * delta; break;                               // O
			case 1:	futureX += velocity * delta * 0.707; futureY -= velocity * delta * 0.707; break;  // NE
			case 3:	futureX += velocity * delta * 0.707; futureY += velocity * delta * 0.707; break;  // SE
			case 5:	futureX -= velocity * delta * 0.707; futureY += velocity * delta * 0.707; break;  // SO
			case 7:	futureX -= velocity * delta * 0.707; futureY -= velocity * delta * 0.707; break;  // NO
			}

			// Si on sort de la map ben en fait non (au cas où)
			if (futureX<0) futureX=0;
			if (futureY<0) futureY=0;
			if (futureX>Constants.mapWidth*Constants.blockSize-width) futureX=Constants.mapWidth*Constants.blockSize-width;
			if (futureY>Constants.mapHeight*Constants.blockSize-height) futureY=Constants.mapHeight*Constants.blockSize-height;

			// Vérification des collisions
			// On numérote les quatres coins de l'entitée comme ça:
			// 0 | 1
			// -----
			// 2 | 3
			boolean[] corners = {false, false, false, false}; // Liste des coins à checker

			switch (moving) { // Pour alléger on check que certains coins selon la direction (3 coins pour un déplacement diagonal, 2 sinon)
			case 0: corners[0]=true; corners[1]=true; break;
			case 1: corners[0]=true; corners[1]=true; corners[3]=true; break;
			case 2: corners[1]=true; corners[3]=true; break;
			case 3: corners[1]=true; corners[3]=true; corners[2]=true; break;
			case 4: corners[3]=true; corners[2]=true; break;
			case 5: corners[3]=true; corners[2]=true; corners[0]=true; break;
			case 6: corners[2]=true; corners[0]=true; break;
			case 7: corners[2]=true; corners[0]=true; corners[1]=true; break;
			}

			if (isColliding(corners, futureX, futureY)) {
				switch (moving) { // Quand on se déplace en diagonale on peut quand meme glisser sur un mur ou non
				case 1:
					if (!isColliding(corners, this.x + velocity * delta, this.y)) this.x=(int)(this.x + velocity * delta);
					else if (!isColliding(corners, this.x, this.y - velocity * delta)) this.y=(int)(this.y - velocity * delta);
					break;
				case 3:
					if (!isColliding(corners, this.x + velocity * delta, this.y)) this.x=(int)(this.x + velocity * delta);
					else if (!isColliding(corners, this.x, this.y + velocity * delta)) this.y=(int)(this.y + velocity * delta);
					break;
				case 5:
					if (!isColliding(corners, this.x - velocity * delta, this.y)) this.x=(int)(this.x - velocity * delta);
					else if (!isColliding(corners, this.x, this.y + velocity * delta)) this.y=(int)(this.y + velocity * delta);
					break;
				case 7:
					if (!isColliding(corners, this.x - velocity * delta, this.y)) this.x=(int)(this.x - velocity * delta);
					else if (!isColliding(corners, this.x, this.y - velocity * delta)) this.y=(int)(this.y - velocity * delta);
					break;
				}
			}
			else {
				this.x = (int) futureX;
				this.y = (int) futureY;
			}
		}
	}

	private boolean isColliding(boolean[] corners, float futureX, float futureY) {
		Image img;
		float cornerX=0, cornerY=0;

		for (int i=0; i<4; i++) {
			if (corners[i]) {
				switch (i) {
				case 0:
					cornerX = futureX-width/2;
					cornerY = futureY-height/2;
					break;
				case 1:
					cornerX = futureX+width/2;
					cornerY = futureY-height/2;
					break;
				case 2:
					cornerX = futureX-width/2;
					cornerY = futureY+height/2;
					break;
				case 3:
					cornerX = futureX+width/2;
					cornerY = futureY+height/2;
					break;
				}

				img = Constants.dungeon.getCurrentFloor().getCollideImage((int)(cornerX/Constants.blockSize), (int)(cornerY/Constants.blockSize));
				if (img != null) {
					Color color = img.getColor((int)(cornerX % Constants.blockSize), (int)(cornerY % Constants.blockSize));
					if (color.getRed()==255 && color.getGreen()==0 && color.getBlue()==0) {
						return true;
					}
				}
				else return true; // Si l'image est null (pour du vide par exemple), on ne peut pas marcher dessus
			}
		}
		return false;
	}


	protected abstract void refreshAnimations();
	protected abstract void updateFacing();

	public void setFacing(int facing) {
		this.facing = facing;
	}

	public void setMoving(int moving) {
		this.moving = moving;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}

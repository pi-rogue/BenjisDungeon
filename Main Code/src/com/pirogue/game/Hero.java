package com.pirogue.game;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Hero {
	
	protected float velocity = 0.5f; // Je sais pas vous mais chez moi ça fait n'importe quoi dès qu'on passe en dessous de 0.5f jsp pourquoi
	protected int x,y, width,height;
	protected int direction;
	protected boolean moving = false;
	protected Animation[][] animations; // Tableau 2D parce que pour chaque direction on a deux anims (en déplacement ou non)
	protected Map map;
	protected Dungeon dungeon;
	protected Inventory inventory;
	
	public Hero(int x, int y) throws SlickException {
		this.inventory = new Inventory();
		this.dungeon = Constants.dungeon;
		this.map = dungeon.getCurrentFloor();
		this.x = x;
		this.y = y;
		SpriteSheet spriteSheet = new SpriteSheet(Constants.heroSprite, Constants.blockSize, Constants.blockSize);
		int IMGwidth = spriteSheet.getWidth();
		int IMGheight = spriteSheet.getHeight();
		this.width = Constants.blockSize;
		this.height = Constants.blockSize;
			
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
		if (inventory.isVisible()) {
			inventory.render(g);
		}
		else {
			g.drawAnimation(animations[direction][moving ? 1:0], (Constants.SCREEN_WIDTH-width)/2, (Constants.SCREEN_HEIGHT-height)/2);
		}
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
			if (futureX>map.width*map.blockSize-width) futureX=map.width*map.blockSize-width;
			if (futureY>map.height*map.blockSize-height) futureY=map.height*map.blockSize-height;

			// Vérification des collisions
			// On numérote les quatres coins du héros comme ça: 
			// 0 | 1
			// -----
			// 2 | 3
			boolean[] corners = {false, false, false, false}; // Liste des coins à checker			

			switch (direction) { // Pour alléger on check que certains coins selon la direction (3 coins pour un déplacement diagonal, 2 sinon)
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
				switch (direction) { // Quand on se déplace en diagonale on peut quand meme glisser sur un mur ou non
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
				 
				img = map.getCollideImage((int)(cornerX/width), (int)(cornerY/height)); 
				if (img != null) {
					Color color = img.getColor((int)(cornerX % width), (int)(cornerY % height));
					if (color.getRed()==255 && color.getGreen()==0 && color.getBlue()==0) {
						return true;
					}
				}
				else return true; // Si l'image est null (pour du vide par exemple), on ne peut pas marcher dessus
			}
		}
		return false;
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
	
	public void toggleInventory() {
		inventory.setVisible(!inventory.isVisible());
	}
	
	public boolean inInventory() {
		return inventory.isVisible();
	}
}

package com.pirogue.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Map {
	
	protected SpriteSheet spritesheet;
	protected SpriteSheet collidesheet;
	private Tile[][] background;
	protected int width, height;
	protected float textureSize;

	public Map(int width, int height, SpriteSheet spr, SpriteSheet col) {
		this.spritesheet = spr;
		this.collidesheet = col;
		this.width = width;
		this.height = height;
		this.background = new Tile[width][height];
		this.textureSize = spr.getSprite(0,0).getWidth();
		
		/* TODO : Génération de l'étage avec le code de Kilian directement dans le             edit kilian : OMW, je check le code et je fais des tests
		 * tableau this.background
		 * 
		 * L'idée c'est de mettre à la place des 0 ou 1 un objet Tile :
		 * (a et b sont les coords de la texture dans le spritesheet)
		 * 
		 * Image texture = spritesheet.getSprite(a, b);
		 * Image collide = collidesheet.getSprite(a, b);
		 * this.background[x][y] = new Tile(texture, collide);
		 * 
		 * Attention à remplir aussi les cases de vide par des Tile() sans paramètres
		 */
		
		for (int i=0; i<width; i++) {
			background[i][0] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
			background[i][height-1] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
		}
		for (int j=0; j<height; j++) {
				background[0][j] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
				background[width-1][j] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
		}
		
		for (int i=1; i<width-1; i++) {
			for (int j=1; j<height-1; j++) {
				this.background[i][j] = new Tile();
			}
		}

		background[width/2][height/2] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
		background[width/2][height/2-1] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
		background[width/2-1][height/2-1] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
		background[width/2-1][height/2] = new Tile(spritesheet.getSprite(0, 0), collidesheet.getSprite(0, 0));
		background[width/2-2][height/2] = new Tile(spritesheet.getSprite(0, 1), collidesheet.getSprite(0, 1));
		
	
	}

	public void render(Graphics g) {
		render(g, 0,0);
	}
	
	public Image getTileImage(int x, int y) {
		return background[x][y].getTexture();
	}

	public Image getCollideImage(int x, int y) {
		return background[x][y].getCollide();
	}

	// J'ai pas trop le temps de tester le truc des offset et je me suis peut-être fail quelque part
	public void render(Graphics g, float offsetX, float offsetY) {
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				Image texture = background[x][y].getTexture();
				
				if (texture != null) {
					g.drawImage(texture, x*textureSize-offsetX, y*textureSize-offsetY);
				}
			}
		}
	}
}
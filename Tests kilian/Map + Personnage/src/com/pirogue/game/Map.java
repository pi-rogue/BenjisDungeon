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
	private boolean grille[][] = new boolean[150][150];
	private String Blocks[][] = new String[150][150];
	private int salleX=0, salleY=0, tailleSalleX=0, tailleSalleY=0;

	public Map(int width, int height, SpriteSheet spr, SpriteSheet col) {
		this.spritesheet = spr;
		this.collidesheet = col;
		this.width = width;
		this.height = height;
		this.background = new Tile[width][height];
		this.textureSize = spr.getSprite(0,0).getWidth();
		
		for(int i=0; i<150; i++) {
			for(int j=0; j<150; j++) {
				this.grille[i][j] = false;		//initialisation des 2 tableaux
				this.Blocks[i][j] = "Vide";
			}
		}
		for(int i=0; i<500; i++) { //nombre de salles générées 
			this.generate();
		}
		this.scanBlock();
	
		
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
	
	public void generate() {										//génération des salles
		this.salleX = 10 + (int)(Math.random() * ((140 - 10) + 1));
		this.salleY = 10 + (int)(Math.random() * ((140 - 10) + 1));//nb aléatoire entre 10 et 140
		this.tailleSalleX = 3 + (int)(Math.random() * ((8 - 3) + 1));
		this.tailleSalleY = 3 + (int)(Math.random() * ((8 - 3) + 1));//nb aléatoire entre 3 et 8
	
		int test = 0;
		for(int i=this.salleY-this.tailleSalleY; i<=this.salleY+this.tailleSalleY; i++) {
			for(int j=this.salleX-this.tailleSalleX; j<=this.salleX+this.tailleSalleX; j++) {
				if(this.grille[i][j] == true) {
					test++;					//on compte le nombre de blocks deja occupés
				}
			}
		}
	
		if(test <= 50) {				//tolérance du nombre de blocks déja occupés
			for(int i=this.salleY-this.tailleSalleY; i<=this.salleY+this.tailleSalleY; i++) {
				for(int j=this.salleX-this.tailleSalleX; j<=this.salleX+this.tailleSalleX; j++) {
					this.grille[i][j] = true;    //génération de la salle si les conditions sont ok
				}									//sinon RIEN !
			}
		}
	}

	public void scanBlock() {
		for(int i=1; i<149; i++) {
			for(int j=1; j<149; j++) {
				
				//test Block généré: cela permet de savoir quel type de block afficher
				if(this.grille[i][j] == true) {
					
					//test Sol
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Sol";
					}
					
					//test Haut
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Haut";
					}
					
					//test Droite
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == false && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Droite";
					}
					
					//test Bas
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Bas";
					}
					
					//test Gauche
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = "Gauche";
					}
					//----------------------------------------------------------------------------------------------------------------------------- Maintenant les blocks de Coins
					//test Coin-Haut-Gauche
					if(this.grille[i-1][j-1] == false && this.grille[i-1][j] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = "Coin-Haut-Gauche";
					}
					
					//test Coin-Haut-Droite 
					if(this.grille[i-1][j] == false && this.grille[i-1][j+1] == false && this.grille[i][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Coin-Haut-Droite";
					}
					
					//test Coin-Bas-Droite
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i][j+1] == false && this.grille[i+1][j+1] == false && this.grille[i+1][j] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Coin-Bas-Droite";
					}
					
					//test Coin-Bas-Gauche
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == false && this.grille[i+1][j-1] == false && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = "Coin-Bas-Gauche";
					}
					//---------------------------------------------------------------------------------------------------------------------------Maitenant les blocks d'Angles
					//test Angle-Haut-Gauche
					if(this.grille[i-1][j-1] == false && this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Angle-Haut-Gauche";
					}
					
					//test Angle-Haut-Droite
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Angle-Haut-Droite";
					}
					
					//test Angle-Bas-Droite
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Angle-Bas-Droite";
					}
					
					//test Angle-Bas-Gauche
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = "Angle-Bas-Gauche";
					}	
				}
			}
		}
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
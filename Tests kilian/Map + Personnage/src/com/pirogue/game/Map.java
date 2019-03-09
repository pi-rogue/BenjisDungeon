package com.pirogue.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;

public class Map {
	
	public boolean vision; // Permet d'afficher les collisions pour debug (touche A)
	
	protected SpriteSheet spritesheet;
	protected SpriteSheet collidesheet;
	protected int width, height;
	protected float textureSize;
	public boolean grille[][] = new boolean[150][150];
	public Tile Blocks[][];
	private int salleX=0, salleY=0, tailleSalleX=0, tailleSalleY=0;
	public int spawnX,spawnY;
	 

	public Map(int width, int height, SpriteSheet spr, SpriteSheet col) {
		this.spritesheet = spr;
		this.collidesheet = col;
		this.width = width;
		this.height = height;
		this.Blocks = new Tile[width][height];
		this.textureSize = spr.getSprite(0,0).getWidth();
		
		for(int i=0; i<150; i++) {
			for(int j=0; j<150; j++) {
				this.grille[i][j] = false;		//initialisation des 2 tableaux
				this.Blocks[i][j] = new Tile(spritesheet.getSprite(3, 1),collidesheet.getSprite(3,1)); //"Vide";
			}
		}
		for(int i=0; i<500; i++) { //nombre de salles générées 
			this.generate();
		}
		this.scanBlock();
	

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
					this.grille[i][j] = true;
					this.spawnX = this.salleX;
					this.spawnY = this.salleY;			//génération de la salle si les conditions sont ok
				}									//sinon RIEN !
			}
		}
	}

	public void scanBlock() {
		for(int i=1; i<149; i++) {
			for(int j=1; j<149; j++) {
				
				//test Block généré: cela permet de savoir quel type de block afficher
				if(this.grille[i][j] == true) {
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(3, 0),collidesheet.getSprite(3,0));//"Sol"; ok
					}
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(1, 1),collidesheet.getSprite(1,1));//"Gauche"; ok 
					}
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == false && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(1, 0),collidesheet.getSprite(1,0));//"Bas"; ok 
					}
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(0, 1),collidesheet.getSprite(0,1));//"Droite"; ok 
					}
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(0, 0),collidesheet.getSprite(0,0));//"Haut"; ok 
					}
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(1, 3),collidesheet.getSprite(1,3));//"Coin-Haut-Gauche"; ok
					}
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(1, 2),collidesheet.getSprite(1,2));//"Coin-Haut-Droite"; pas ok
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i][j+1] == false && this.grille[i+1][j] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(0, 2),collidesheet.getSprite(0,2));//"Coin-Bas-Droite";
					}
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == false && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(0, 3),collidesheet.getSprite(0,3));//"Coin-Haut-Droite"; ok
					}
					if(this.grille[i-1][j-1] == false && this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(3, 3),collidesheet.getSprite(3,3));//"Angle-Haut-Gauche";ok
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(3, 2),collidesheet.getSprite(3,2));//"Angle-Haut-Droite";
					}
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(2, 2),collidesheet.getSprite(2,2));//"Angle-Bas-Droite";
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = new Tile(spritesheet.getSprite(2, 3),collidesheet.getSprite(2,3));//"Angle-Bas-Gauche"; ok
					}	
				}
			}
		}
	}



	public void render(Graphics g) {
		render(g, 0,0);
	}
	
	public Image getTileImage(int x, int y) {
		return Blocks[x][y].getTexture();
	}

	public Image getCollideImage(int x, int y) {
		return Blocks[x][y].getCollide();
	}

	// J'ai pas trop le temps de tester le truc des offset et je me suis peut-être fail quelque part
	public void render(Graphics g, float offsetX, float offsetY) {
		for (int x=0; x<width; x++) {
			for (int y=0; y<height; y++) {
				Image texture;
				if (this.vision) texture = Blocks[x][y].getCollide();
				else texture = Blocks[x][y].getTexture();
				
				if (texture != null) {
					g.drawImage(texture, x*textureSize-offsetX, y*textureSize-offsetY);
				}
			}
		}
	}
}
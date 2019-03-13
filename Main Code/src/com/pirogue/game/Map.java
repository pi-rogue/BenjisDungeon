package com.pirogue.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Map {
	
	public boolean vision; // Permet d'afficher les collisions pour debug (touche A)
	
	protected int width, height;
	protected float blockSize;
	protected boolean grille[][];
	protected Tile Blocks[][];
	private int salleX=0, salleY=0, tailleSalleX=0, tailleSalleY=0;
	public int spawnX,spawnY;
	 

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		this.Blocks = new Tile[width][height];
		this.grille = new boolean[width][height];
		this.blockSize = Constants.blockSize;
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				this.grille[i][j] = false;		//initialisation des 2 tableaux
				this.Blocks[i][j] = new Tile(Constants.spritesheet.getSprite(3, 1),Constants.collidesheet.getSprite(3, 1)); //"Vide";
			}
		}

		for(int i=0; i<Constants.roomsRatio; i++) { //nombre de salles générées
			this.generate();
		}
		this.scanBlock();
	}
	
	public void generate() {										//génération des salles
		this.salleX = 10 + (int)(Math.random() * (((width-10) - 10) + 1));
		this.salleY = 10 + (int)(Math.random() * (((height-10) - 10) + 1));//nb aléatoire entre 10 et height-10
		this.tailleSalleX = 3 + (int)(Math.random() * ((8 - 3) + 1));
		this.tailleSalleY = 3 + (int)(Math.random() * ((8 - 3) + 1));//nb aléatoire entre 3 et 8
	
		int test = 0;
		for(int i=this.salleX-this.tailleSalleX; i<=this.salleX+this.tailleSalleX; i++) {
			for(int j=this.salleY-this.tailleSalleY; j<=this.salleY+this.tailleSalleY; j++) {
				if(this.grille[i][j] == true) {
					test++;					//on compte le nombre de blocks deja occupés
				}
			}
		}
	
		if(test <= 50) {				//tolérance du nombre de blocks déja occupés
		for(int i=this.salleX-this.tailleSalleX; i<=this.salleX+this.tailleSalleX; i++) {
			for(int j=this.salleY-this.tailleSalleY; j<=this.salleY+this.tailleSalleY; j++) {
					this.grille[i][j] = true;			//génération de la salle si les conditions sont ok
					this.spawnX = this.salleX;	//Coordonnées de spawn du héros au milieu de la salle
					this.spawnY = this.salleY;	//
				}									//sinon RIEN !
			}
		}
	}

	public void scanBlock() {
		for(int i=1; i<width-1; i++) {
			for(int j=1; j<height-1; j++) {
				
				//test Block généré: cela permet de savoir quel type de block afficher
				if(this.grille[i][j] == true) {
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						int random = (int)(Math.random() * Constants.Sols.length); //nb aléatoire entre 0 et 30 exclu
						this.Blocks[i][j] = Constants.Sols[random];
					}
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						if(this.Blocks[i][j-1].equals(Constants.Droite)) {
							this.Blocks[i][j-1] = Constants.CoinBD;
							this.Blocks[i][j] = Constants.CoinHG;
						}
						else {
							this.Blocks[i][j] = Constants.Gauche;
						}	 
					}
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == false && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						if(this.Blocks[i-1][j].equals(Constants.Haut)) {
							this.Blocks[i-1][j] = Constants.CoinHD;
							this.Blocks[i][j] = Constants.CoinBG;
						}
						else {
							this.Blocks[i][j] = Constants.Bas;
						}
					}
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == false && this.grille[i][j-1] == true) {
						if(this.Blocks[i][j-1].equals(Constants.Gauche)) {
							this.Blocks[i][j-1] = Constants.CoinBG;
							this.Blocks[i][j] = Constants.CoinHD;
						}
						else {
							this.Blocks[i][j] = Constants.Droite;
						}
					}
					if(this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == false) {
						if(this.Blocks[i-1][j].equals(Constants.Bas)) {
							this.Blocks[i-1][j] = Constants.CoinBD;
							this.Blocks[i][j] = Constants.CoinHG;
						}
						else {
							this.Blocks[i][j] = Constants.Haut; 
						}
					}
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = Constants.CoinHG;
					}
					if(this.grille[i-1][j] == false && this.grille[i][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = Constants.CoinBG;
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i][j+1] == false && this.grille[i+1][j] == false && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = Constants.CoinBD;
					}
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == false && this.grille[i][j-1] == false) {
						this.Blocks[i][j] = Constants.CoinHD;
					}
					if(this.grille[i-1][j-1] == false && this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = Constants.AngleHG;
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = Constants.AngleHD;
					}
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						if(this.Blocks[i][j].equals(Constants.AngleHG)) {
							this.Blocks[i][j] = Constants.Inter1;
						}
						else {
							this.Blocks[i][j] = Constants.AngleBD;
						}
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i+1][j-1] == false && this.grille[i][j-1] == true) {
						if(this.Blocks[i][j].equals(Constants.AngleHD)) {
							this.Blocks[i][j] = Constants.Inter2;
						}
						else {
							this.Blocks[i][j] = Constants.AngleBG;
						}
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

	public void render(Graphics g, float offsetX, float offsetY) {
		int Xi=(Constants.dungeon.hero.getX()-Constants.SCREEN_WIDTH/2)/Constants.blockSize -1;
		int Yi=(Constants.dungeon.hero.getY()-Constants.SCREEN_HEIGHT/2)/Constants.blockSize -1;
		int Xf=(Constants.dungeon.hero.getX()+Constants.SCREEN_WIDTH/2)/Constants.blockSize +1;
		int Yf=(Constants.dungeon.hero.getY()+Constants.SCREEN_HEIGHT/2)/Constants.blockSize +1;
		if (Xi<0) Xi=0; if (Xf>width) Xf=width;
		if (Yi<0) Yi=0; if (Yf>height) Yf=height;
		for (int x=Xi; x<Xf; x++) {
			for (int y=Yi; y<Yf; y++) {
				Image texture;
				if (this.vision) texture = Blocks[x][y].getCollide();
				else texture = Blocks[x][y].getTexture();
				
				if (texture != null) {
					g.drawImage(texture, x*blockSize-offsetX, y*blockSize-offsetY);
				}
			}
		}
	}
}
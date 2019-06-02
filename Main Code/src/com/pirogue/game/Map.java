package com.pirogue.game;

import java.util.ArrayList;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import com.pirogue.entity.Entity;
import com.pirogue.entity.mob.Slime;

public class Map {
	
	public int width, height;
	protected boolean grille[][];
	protected Tile Blocks[][];
	private int salleX=0, salleY=0, tailleSalleX=0, tailleSalleY=0;
	public int spawnX,spawnY;
	public ArrayList<Entity> entities = new ArrayList<Entity>();
	 

	public Map(int width, int height) {
		this.width = width;
		this.height = height;
		this.Blocks = new Tile[width][height];
		this.grille = new boolean[width][height];
		
		for(int i=0; i<width; i++) {
			for(int j=0; j<height; j++) {
				this.grille[i][j] = false;		//initialisation des 2 tableaux
				this.Blocks[i][j] = Constants.Vide;
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
						if (Math.random() > 0.7) { // 70% de tiles n'ont pas de défauts (à changer peut être)
							int random = 1 + (int)(Math.random() * (Constants.Sols.length-1)); //nb aléatoire entre 1 et Sols.length (exclu)
							this.Blocks[i][j] = Constants.Sols[random];
						}
						else {this.Blocks[i][j] = Constants.Sols[0];}
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
						this.Blocks[i][j] = Constants.AngleBD;
					}
					if(this.grille[i-1][j-1] == true && this.grille[i-1][j] == true && this.grille[i-1][j+1] == false && this.grille[i][j+1] == true && this.grille[i+1][j+1] == true && this.grille[i+1][j] == true && this.grille[i][j-1] == true) {
						this.Blocks[i][j] = Constants.AngleHD;
					}
					if(this.grille[i-1][j] == true && this.grille[i-1][j+1] == true && this.grille[i][j+1] == true && this.grille[i+1][j+1] == false && this.grille[i+1][j] == true && this.grille[i+1][j-1] == true && this.grille[i][j-1] == true) {
						if(this.Blocks[i][j].equals(Constants.AngleBD)) {
							this.Blocks[i][j] = Constants.Inter1;
						}
						else {
							this.Blocks[i][j] = Constants.AngleHG;
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


	public void spawnMob(int j) throws SlickException {
		int x, y;
		String[] colors = {"red", "green", "blue"};
		for(int i=0; i<j; i++) {
			do { // On choisit des coordonnées aléatoires jusqu'à ce qu'elles soient valides
				x = 1 + (int)(Math.random() * ((Constants.mapWidth-1 - 1) + 1));
				y = 1 + (int)(Math.random() * ((Constants.mapHeight-1 - 1) + 1));
			} while(Blocks[x][y].equals(Constants.Droite) || Blocks[x][y].equals(Constants.Vide) || Blocks[x][y].equals(Constants.Gauche) || Blocks[x][y].equals(Constants.Bas) || Blocks[x][y].equals(Constants.Haut) || Blocks[x][y].equals(Constants.AngleBD) || Blocks[x][y].equals(Constants.AngleHD) || Blocks[x][y].equals(Constants.AngleBG) || Blocks[x][y].equals(Constants.AngleHG) || Blocks[x][y].equals(Constants.CoinHG) || Blocks[x][y].equals(Constants.CoinHD) || Blocks[x][y].equals(Constants.CoinBG) || Blocks[x][y].equals(Constants.CoinBD) || Blocks[x][y].equals(Constants.Inter1) || Blocks[x][y].equals(Constants.Inter2));
			entities.add(new Slime(x, y, colors[(int)(Math.random() * 3)])); // Et on fait spawn un Slime de couleur random
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

	public void render(Graphics g, int heroX, int heroY) {
		// On n'affiche que les Tiles qui sont dans l'écran (+1 bloc au cas où) pour améliorer les perfs
		int Xi=(heroX-Constants.SCREEN_WIDTH/2)/Constants.blockSize -1;
		int Yi=(heroY-Constants.SCREEN_HEIGHT/2)/Constants.blockSize -1;
		int Xf=(heroX+Constants.SCREEN_WIDTH/2)/Constants.blockSize +1;
		int Yf=(heroY+Constants.SCREEN_HEIGHT/2)/Constants.blockSize +1;
		if (Xi<0) Xi=0; if (Xf>width) Xf=width;    // On s'assure de bien rester dans les bornes de la map
		if (Yi<0) Yi=0; if (Yf>height) Yf=height;  // 
		for (int x=Xi; x<Xf; x++) {
			for (int y=Yi; y<Yf; y++) {
				Image texture;
				if (Constants.debug) texture = Blocks[x][y].getCollide();
				else texture = Blocks[x][y].getTexture();
				
				if (texture != null) {
					g.drawImage(texture, x*Constants.blockSize - heroX + Constants.SCREEN_WIDTH/2, y*Constants.blockSize - heroY + Constants.SCREEN_HEIGHT/2);
				}
			}
		}
		
		renderEntities(g, heroX, heroY);
	}
	
	public void renderEntities(Graphics g, int heroX, int heroY) {
		// On n'affiche que les mobs qui sont dans l'écran (+1 bloc au cas où) pour améliorer les perfs
		int Xi=heroX-Constants.SCREEN_WIDTH/2-Constants.blockSize;
		int Yi=heroY-Constants.SCREEN_WIDTH/2-Constants.blockSize;
		int Xf=heroX+Constants.SCREEN_WIDTH/2+Constants.blockSize;
		int Yf=heroY+Constants.SCREEN_WIDTH/2+Constants.blockSize;
		
		for(int i=0; i<entities.size(); i++) {
			Entity entity = entities.get(i);
			if (entity.x>=Xi && entity.x<=Xf && entity.y>=Yi && entity.y<=Yf ) {
				entity.render(g, heroX, heroY);
			}
		}
	}

	/*
	public void killEntity(Mob entity) {
		entities.remove(entity);
	}*/
}
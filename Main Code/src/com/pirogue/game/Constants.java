package com.pirogue.game;

import java.io.File;
import java.util.HashMap;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Constants {
	// ---------- Settings ---------- //
	
	/* GLOBAL */
	public static boolean SHOW_FPS = true;
	public static boolean FULLSCREEN = false;
	public static boolean VERTICAL_SYNC = false;
	public static int DELTA_MAX = 20;       // Permet de ne pas (trop) traverser les murs si il y a un freeze
	public static int FPS_MAX = 200;   // Ca évite de faire chauffer les bons pcs qui tournent à 2000 fps
	public static int SCREEN_WIDTH = 1366; // Voir résolutions compatibles dans Trash Code > Resolutions.txt
	public static int SCREEN_HEIGHT = 768; // On pourra faire un sélecteur plus tard quand on aura une page de settings
	public static String tileset = "assets/map/tileset.png";
	public static String collide = "assets/map/collide.png";
	
	/* INVENTORY */
	public static String inventoryBackground = "assets/gui/gui_inventory.png";
	public static String inventoryCells = "assets/gui/cells_inventory.png";
	public static String inventorySelected = "assets/gui/selected.png";
	public static int cellSize = 64; // Les seules cases reconnues sur le background sont les carrés de cette taille 
	public static Color head = new Color(255,0,0);
	public static Color chest = new Color(0,255,0);
	public static Color legs = new Color(0,0,255);
	public static Color foots = new Color(255,255,0);
	public static Color leftHand = new Color(0,255,255);
	public static Color rightHand = new Color(255,0,255);
	public static Color invCell = new Color(128,128,128);
	public static Color heroCell = new Color(216,216,216);
	
	/* MAP */
	public static int mapWidth = 150;
	public static int mapHeight = 150;
	public static int roomsRatio = 1000;
	public static int blockSize = 64;
	
	
	// ------ Keyboard Configuration ------ //
	public static int KEY_DebugView = Input.KEY_A;
	public static int KEY_Exit = Input.KEY_ESCAPE;
	public static int KEY_Up = Input.KEY_Z;
	public static int KEY_Left = Input.KEY_Q;
	public static int KEY_Down = Input.KEY_S;
	public static int KEY_Right = Input.KEY_D;
	public static int KEY_Inventory = Input.KEY_TAB;
	//public static int AxeX = Input.
	
	
	// ------ Variables ------ //
	public static int mouseX, mouseY;
	public static boolean debug = false;
	public static boolean mousePressed = false;
	public static GameContainer container;
	public static Dungeon dungeon;
	public static int nbFloors=1;
	public static int nbMob=300;
	public static HashMap<String, Animation[]> animations = new HashMap<String, Animation[]>(); // Contient toutes les animations de tous les mobs/joueurs
	public static Tile Droite, Gauche, Bas, Haut,
						AngleHG, AngleHD, AngleBG, AngleBD,
						CoinHG, CoinHD, CoinBG, CoinBD,
						Inter1, Inter2, Vide;
	public static Tile[] Sols, Murs;
	
	// ------ Initialization ------ //
	public static void init() throws SlickException {
		SpriteSheet tilesheet = new SpriteSheet(tileset, blockSize, blockSize);
		SpriteSheet collidesheet = new SpriteSheet(collide, blockSize, blockSize);
		Droite = 	new Tile(tilesheet.getSprite(0, 6),collidesheet.getSprite(0, 6));
		Gauche = 	new Tile(tilesheet.getSprite(1, 6),collidesheet.getSprite(1, 6));
		Bas = 		new Tile(tilesheet.getSprite(2, 5),collidesheet.getSprite(2, 5));
		Haut = 		new Tile(tilesheet.getSprite(3, 5),collidesheet.getSprite(3, 5));
		AngleHG = 	new Tile(tilesheet.getSprite(2, 7),collidesheet.getSprite(2, 7));
		AngleHD = 	new Tile(tilesheet.getSprite(3, 7),collidesheet.getSprite(3, 7));
		AngleBG = 	new Tile(tilesheet.getSprite(2, 8),collidesheet.getSprite(2, 8));
		AngleBD = 	new Tile(tilesheet.getSprite(3, 8),collidesheet.getSprite(3, 8));
		CoinHG = 	new Tile(tilesheet.getSprite(1, 8),collidesheet.getSprite(1, 8));
		CoinHD = 	new Tile(tilesheet.getSprite(0, 8),collidesheet.getSprite(0, 8));
		CoinBG = 	new Tile(tilesheet.getSprite(1, 7),collidesheet.getSprite(1, 7));
		CoinBD = 	new Tile(tilesheet.getSprite(0, 7),collidesheet.getSprite(0, 7));
		Inter1 = 	new Tile(tilesheet.getSprite(3, 6),collidesheet.getSprite(3, 6));
		Inter2 = 	new Tile(tilesheet.getSprite(2, 6),collidesheet.getSprite(2, 6));
		Vide = 		new Tile(tilesheet.getSprite(0, 9),collidesheet.getSprite(0, 9));
		Sols = new Tile[20]; // C'est hardcodé ici ça me plaît moyen mais c'est mieux d'avoir tout réuni sur un seul tileset
		Murs = new Tile[4]; // On a plusieurs murs horizontaux différents aussi :)
		
		int n=0;
		for (int i=0; i<4; i++) {
			for (int j=0; j<5; j++) {
				Sols[n] = new Tile(tilesheet.getSprite(i, j),collidesheet.getSprite(i,j));
				n++;
			}
		}
		n=0;
		for (int i=0; i<tilesheet.getHorizontalCount(); i++) {
			Murs[n] = new Tile(tilesheet.getSprite(i, 5),collidesheet.getSprite(i, 5));
			n++;
		}
		
		initAnimations(new File("src/assets/sprites"));
	}

	public static void initAnimations(File currentFile) throws SlickException {
		for (File file : currentFile.listFiles()) {
			if (file.isDirectory())
				initAnimations(file);
			else {
				String key = String.join(" ", file.getPath().substring(19, file.getPath().indexOf(".")).split("\\\\"));
				key = key.split(" ", 2)[1];
				SpriteSheet sprite = new SpriteSheet(file.getPath(), blockSize * (key.matches(" attack ")?2:1), blockSize);
				int duration = key.matches("slime") ? 200 : 100;
				int spriteImgWidth = sprite.getWidth();
				int spriteImgHeight = sprite.getHeight();
				Animation[] anims = new Animation[spriteImgHeight/blockSize];

				for (int n=0; n<spriteImgHeight/blockSize; n++) {
					Animation anim = new Animation();
					for (int i=0; i<spriteImgWidth/blockSize; i++) {
						anim.addFrame(sprite.getSprite(i, n), duration);
					}
					anims[n] = anim;
				}
				animations.put(key, anims);
			}
		}
	}
}
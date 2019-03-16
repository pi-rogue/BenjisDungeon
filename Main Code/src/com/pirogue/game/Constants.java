package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Constants {

	// ---------- Settings ---------- //
	
	/* GLOBAL */
	public static boolean SHOW_FPS = true;
	public static boolean FULLSCREEN = true;
	public static boolean VERTICAL_SYNC = false;  // Askip ça évite des problèmes d'affichage (synchronisation verticale)
	public static int DELTA_MAX = 20;       // Permet de ne pas (trop) traverser les murs si il y a un freeze
	public static int FPS_MAX = 200;   // Ca évite de faire chauffer les bons pcs qui tournent à 2000 fps
	public static int SCREEN_WIDTH = 1366; // Voir résolutions compatibles dans Trash Code > Resolutions.txt
	public static int SCREEN_HEIGHT = 768; // On pourra faire un sélecteur plus tard quand on aura une page de settings
	public static String tileset = "assets/map/64x64/test_tileset_wiwi.png";
	public static String collide = "assets/map/64x64/test_collide_wiwi.png";
	public static String ground = "assets/map/64x64/new_insane_ground.png";
	public static String heroSprite = "assets/sprites/64x64/mage.png";
	
	/* INVENTORY */
	public static String inventoryBackground = "assets/gui/gui_inventory.png";
	public static String inventoryCells = "assets/gui/cells_inventory.png";
	public static String inventorySelected = "assets/gui/selected.png";
	public static int cellSize = 64;
	public static Color head = new Color(255,0,0);
	public static Color chest = new Color(0,255,0);
	public static Color legs = new Color(0,0,255);
	public static Color foots = new Color(255,255,0);
	public static Color leftHand = new Color(0,255,255);
	public static Color rightHand = new Color(255,0,255);
	public static Color invCell = new Color(128,128,128);
	
	
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
	
	// ------ Variables ------ //
	public static int mouseX, mouseY;   // Je sais pas si c'est le plus propre de faire ça comme ça mais au pire osef
	public static boolean mousePressed = false; 
	public static GameContainer container;
	public static Dungeon dungeon;
    public static SpriteSheet spritesheet;
	public static SpriteSheet collidesheet;
	public static Tile Droite, Gauche, Bas, Haut,
						AngleHG, AngleHD, AngleBG, AngleBD,
						CoinHG, CoinHD, CoinBG, CoinBD,
						Inter1, Inter2;
	public static Tile[] Sols;
	
	// ------ Initialization ------ //
	public static void init() throws SlickException {
		spritesheet = new SpriteSheet(tileset, blockSize, blockSize);
		collidesheet = new SpriteSheet(collide, blockSize, blockSize);
		Droite = new Tile(spritesheet.getSprite(0, 1),collidesheet.getSprite(0,1));
		Gauche = new Tile(spritesheet.getSprite(1, 1),collidesheet.getSprite(1,1));
		Bas = new Tile(spritesheet.getSprite(1, 0),collidesheet.getSprite(1,0));
		Haut = new Tile(spritesheet.getSprite(0, 0),collidesheet.getSprite(0,0));
		AngleHG = new Tile(spritesheet.getSprite(3, 3),collidesheet.getSprite(3,3));
		AngleHD = new Tile(spritesheet.getSprite(3, 2),collidesheet.getSprite(3,2));
		AngleBG = new Tile(spritesheet.getSprite(2, 3),collidesheet.getSprite(2,3));
		AngleBD = new Tile(spritesheet.getSprite(2, 2),collidesheet.getSprite(2,2));
		CoinHG = new Tile(spritesheet.getSprite(1, 3),collidesheet.getSprite(1,3));
		CoinHD = new Tile(spritesheet.getSprite(0, 3),collidesheet.getSprite(0,3));
		CoinBG = new Tile(spritesheet.getSprite(1, 2),collidesheet.getSprite(1,2));
		CoinBD = new Tile(spritesheet.getSprite(0, 2),collidesheet.getSprite(0,2));
		Inter1 = new Tile(spritesheet.getSprite(2, 0),collidesheet.getSprite(2,0));
		Inter2 = new Tile(spritesheet.getSprite(2, 1),collidesheet.getSprite(2,1));
		
		SpriteSheet groundsheet = new SpriteSheet(ground, blockSize, blockSize);
		Sols = new Tile[groundsheet.getVerticalCount() * groundsheet.getHorizontalCount()];
		int n=0;
		for (int i=0; i<groundsheet.getHorizontalCount(); i++) {
			for (int j=0; j<groundsheet.getVerticalCount(); j++) {
				Sols[n] = new Tile(groundsheet.getSprite(i, j),collidesheet.getSprite(3,0));
				n++;
			}
		}
	}
	
	
}
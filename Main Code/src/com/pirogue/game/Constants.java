package com.pirogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Constants {

	// ---------- Settings ---------- //
	
	/* GLOBAL */
	public static boolean SHOW_FPS = true;
	public static boolean FULLSCREEN = false;
	public static boolean VERTICAL_SYNC = false;  // Askip ça évite des problèmes d'affichage (synchronisation verticale)
	public static int DELTA_MAX = 20;       // Permet de ne pas (trop) traverser les murs si il y a un freeze
	private static int blockNumbersHorizontal = 20;    // Nombre de blocs à afficher sur l'écran
	private static int blockNumbersVertical = 15;      // Si vous voulez changer il faut enlever le fullscreen (on verra plus tard pour fix ça)
	public static String tileset = "assets/map/test_tileset_wiwi.png";
	public static String collide = "assets/map/test_collide_wiwi.png";
	
	/* MAP */
	public static int mapWidth = 150;
	public static int mapHeight = 150;
	public static int roomsRatio = 1000;
	public static int blockSize = 32;
	    	// En soi on pourrait aussi mettre ici le seuil de cases qui peuvent se superposer quand on génère une map, faut voir avec Kiki
	
	
	// ------ Keyboard Configuration ------ //
	public static int KEY_DebugView = Input.KEY_A;
	public static int KEY_Exit = Input.KEY_ESCAPE;
	public static int KEY_Up = Input.KEY_UP;
	public static int KEY_Down = Input.KEY_DOWN;
	public static int KEY_Left = Input.KEY_LEFT;
	public static int KEY_Right = Input.KEY_RIGHT;
	
	// Variables //   (je savais pas comment les appeler en fait c'est des constantes mais qui changent à chaque démarrage du jeu ou propres au pc)
	public static GameContainer container;
	public static Dungeon dungeon;
	public static int SCREEN_WIDTH = blockNumbersHorizontal*blockSize;
	public static int SCREEN_HEIGHT = blockNumbersVertical*blockSize;
    public static SpriteSheet spritesheet;
	public static SpriteSheet collidesheet;
	
	//les différents types de tuiles
	public static Tile Droite, Gauche, Bas, Haut, AngleHG, AngleHD, AngleBG, AngleBD, CoinHG, CoinHD, CoinBG, CoinBD, Sol;
	
	//initiallisation des spritesheets
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
		Sol = new Tile(spritesheet.getSprite(3, 0),collidesheet.getSprite(3,0));
	}
}
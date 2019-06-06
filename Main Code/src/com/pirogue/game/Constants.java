package com.pirogue.game;

import java.io.File;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.pirogue.game.util.AnimationsContainer;

public class Constants {

// ---------- Settings ---------- //
	/* GLOBAL */
	public static boolean SHOW_FPS = true;
	public static boolean FULLSCREEN = true;
	public static boolean VERTICAL_SYNC = false;
	public static int DELTA_MAX = 20; // Permet de ne pas (trop) traverser les murs si il y a un freeze
	public static int FPS_MAX = 200;
	public static int SCREEN_WIDTH = 1366; // Voir résolutions compatibles dans Trash Code > Resolutions.txt
	public static int SCREEN_HEIGHT = 768; // On pourra faire un sélecteur plus tard quand on aura une page de settings
	public static String tileset = "assets/map/tileset.png"; // Image du tileset
	public static String collide = "assets/map/collide.png"; // Image des collisions avec le tileset

	/* INVENTORY */
	public static String inventoryBackground = "assets/gui/gui_inventory.png"; // Image de fond à afficher dans l'inventaire
	public static String inventoryCells = "assets/gui/cells_inventory.png"; // Image permettant de détecter l'emplacement des cases de l'inventaire
	public static String inventorySelected = "assets/gui/selected.png"; // Image à afficher quand la souris passe sur une case
	public static int cellSize = 64; // Taille des cases à reconnaître sur le background
	public static Color head = new Color(255,0,0);          //
	public static Color chest = new Color(0,255,0);         //
	public static Color legs = new Color(0,0,255);          // Ces couleurs correspondent aux différentes couleurs à détecter
	public static Color foots = new Color(255,255,0);       // sur l'image inventoryCells, afin de différencier les cases
	public static Color leftHand = new Color(0,255,255);    // d'inventaire des cases d'équipement, ainsi que l'emplacement où
	public static Color rightHand = new Color(255,0,255);   // afficher le héros.
	public static Color invCell = new Color(128,128,128);   //
	public static Color heroCell = new Color(216,216,216);  //

	/* MAP */
	public static int mapWidth = 150;  // Largeur de la map
	public static int mapHeight = 150; // Hauteur de la map
	public static int roomsRatio = 1000; // Nombre de salles à générer par étages
	public static int blockSize = 64; // Taille d'un bloc de la map
	
	/* MISCELLANEOUS */
	public static int nbFloors=1; // Nombre d'étages à générer dans le dungeon
	public static int nbMob=250; // Nombre de mob à générer sur la map 
	public static int nbChest=30; // Nombre de Chest générés par map
	public static int nbStairs=1;
	public static int slideDelay = 30; // Nombre de tours de boucle où le héros doit glisser quand on relâche le clavier (momentum)
	
	
// ------ Keyboard Configuration ------ //
	public static int KEY_DebugView = Input.KEY_F3;
	public static int KEY_Exit = Input.KEY_ESCAPE;
	public static int KEY_Up = Input.KEY_Z;
	public static int KEY_Left = Input.KEY_Q;
	public static int KEY_Down = Input.KEY_S;
	public static int KEY_Right = Input.KEY_D;
	public static int KEY_Inventory = Input.KEY_TAB;
	public static int KEY_Console = Input.KEY_APOSTROPHE;
	public static int KEY_Attack = Input.MOUSE_LEFT_BUTTON;

// ------ Variables ------ //
	public static int mouseX, mouseY; // Coordonnées de la souris
	public static String currentScreen = "running"; // écran à afficher
	public static boolean debug = false; // true quand on veut afficher la debug_view
	public static String heroCollision; // Sert à l'afficher dans la vue debug
	public static boolean neutrino = false;
	public static boolean mousePressed = false; // true quand le bouton gauche de la souris est enfoncé
	public static boolean mouseWasPressed = false; // garde en mémoire l'ancien état de mousePressed (permet de détecter des clicks)
	public static boolean inConsole = false; // true si la console est ouverte
	public static GameContainer container; // Gère ce qui est propre au jeu au niveau de l'OS, par exemple les inputs, la musique, le fullscreen, etc
	public static Dungeon dungeon; // Pour accéder au dungeon
	public static AnimationsContainer animations = new AnimationsContainer(); // Contient toutes les animations de tous les mobs/joueurs
	public static Tile Droite, Gauche, Bas, Haut,
					   AngleHG, AngleHD, AngleBG, AngleBD,
					   CoinHG, CoinHD, CoinBG, CoinBD,
					   Inter1, Inter2, Vide;
	public static Tile[] Sols, Murs;
	private static int IDCounter = 0;
	
// ------ Equilibrage slime ------ //	
	public static float slimeSpeed =  0.15f;
	public static int slimeAggro = 350;
	public static int slimeRange = Constants.blockSize+10;
	public static int slimeDamages = 10;

// ------ Equilibrage fire ghosts ------ //
	public static int fireGhostCooldown = 500;
	public static float fireGhostSpeed = 0.3f;
	public static int fireGhostAggro = Constants.blockSize*10;
	public static int fireGhostRange = Constants.blockSize*5;
	public static float fireBallSpeed = 0.5f; // Attention a ne pas trop le reduire sinon ca fausse l'angle de déplacement 
	public static int fireBallDamages = 30;

// ------ Initialization ------ //
	public static void init() throws SlickException {
		animations.loadAnimations(new File("src/assets/sprites"));

		SpriteSheet tilesheet    = new SpriteSheet(tileset, blockSize, blockSize);
		SpriteSheet collidesheet = new SpriteSheet(collide, blockSize, blockSize);
        Droite =    new Tile(tilesheet.getSprite(0, 6),collidesheet.getSprite(0, 6)); //
        Gauche =    new Tile(tilesheet.getSprite(1, 6),collidesheet.getSprite(1, 6)); //
        Bas =       new Tile(tilesheet.getSprite(2, 5),collidesheet.getSprite(2, 5)); //
        Haut =      new Tile(tilesheet.getSprite(3, 5),collidesheet.getSprite(3, 5)); //
        AngleHG =   new Tile(tilesheet.getSprite(2, 7),collidesheet.getSprite(2, 7)); //
        AngleHD =   new Tile(tilesheet.getSprite(3, 7),collidesheet.getSprite(3, 7)); // Voir Tile.java pour plus d'infos
        AngleBG =   new Tile(tilesheet.getSprite(2, 8),collidesheet.getSprite(2, 8)); //
        AngleBD =   new Tile(tilesheet.getSprite(3, 8),collidesheet.getSprite(3, 8)); //
        CoinHG =    new Tile(tilesheet.getSprite(1, 8),collidesheet.getSprite(1, 8)); //
        CoinHD =    new Tile(tilesheet.getSprite(0, 8),collidesheet.getSprite(0, 8)); //
        CoinBG =    new Tile(tilesheet.getSprite(1, 7),collidesheet.getSprite(1, 7)); //
        CoinBD =    new Tile(tilesheet.getSprite(0, 7),collidesheet.getSprite(0, 7)); //
        Inter1 =    new Tile(tilesheet.getSprite(3, 6),collidesheet.getSprite(3, 6)); //
        Inter2 =    new Tile(tilesheet.getSprite(2, 6),collidesheet.getSprite(2, 6)); //
        Vide =      new Tile(tilesheet.getSprite(0, 9),collidesheet.getSprite(0, 9)); //
		Sols = new Tile[20]; // Attention c'est hardcodé, penser à modifier la taille de ce tableau si on veut ajouter des variations de sol
		Murs = new Tile[4]; // TODO: Implémenter proprement les murs horizontaux (en créant un Tile.equals par type de bloc plutot que par objet (je me comprends)) 
		
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
	}
	
	public static int randomRound(float a) {
		/*
		 * Cette fonction est utilisée dans Entity.update() afin d'arrondir un float, en arrondissant de façon aléatoire
		 * entre l'entier supérieur ou inférieur si la partie décimale du nombre est .5
		 */
		//int rand = (int) (Math.random() * 2); // Nombre aléatoire soit 0 soit 1
		if (a%0.5==0) return (int) (Math.random()<0.5 ? Math.floor(a) : Math.ceil(a));
		return Math.round(a);
	}
	
	public static int newID() {
		int id = IDCounter;
		IDCounter++;
		return id;
	}
}

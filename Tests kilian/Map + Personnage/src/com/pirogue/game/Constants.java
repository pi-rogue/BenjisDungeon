package com.pirogue.game;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Constants {

	// ---------- Settings ---------- //
	
	/* GLOBAL */
	public static boolean SHOW_FPS = true;
	public static boolean FULLSCREEN = true;
	public static boolean VERTICAL_SYNC = true;  // Askip �a �vite des probl�mes d'affichage (synchronisation verticale)
	public static int DELTA_MAX = 20;       // Permet de ne pas (trop) traverser les murs si il y a un freeze
	private static int blockNumbersHorizontal = 20;    // Nombre de blocs � afficher sur l'�cran
	private static int blockNumbersVertical = 15;      // Y'a des ratios � respecter si on se met en fullscreen, � la limite on fera une enum
    
	/* MAP */
	public static int mapWidth = 150;
	public static int mapHeight = 150;
	public static int roomsRatio = 1000;
	public static int blockSize = 32;
	    	// En soi on pourrait aussi mettre ici le seuil de cases qui peuvent se superposer quand on g�n�re une map, faut voir avec Kiki
	
	
	// ------ Keyboard Configuration ------ //
	public static int KEY_ViewCollisions = Input.KEY_A;
	public static int KEY_Exit = Input.KEY_ESCAPE;
	public static int KEY_Up = Input.KEY_UP;
	public static int KEY_Down = Input.KEY_DOWN;
	public static int KEY_Left = Input.KEY_LEFT;
	public static int KEY_Right = Input.KEY_RIGHT;
	
	// Variables //   (je savais pas comment les appeler en fait c'est des constantes mais qui changent � chaque d�marrage du jeu ou propres au pc)
	public static GameContainer container;
	public static Dungeon dungeon;
	public static int SCREEN_WIDTH = blockNumbersHorizontal*blockSize;
	public static int SCREEN_HEIGHT = blockNumbersVertical*blockSize;
}
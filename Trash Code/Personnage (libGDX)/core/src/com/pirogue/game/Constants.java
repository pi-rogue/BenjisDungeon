package com.pirogue.game;

public class Constants {
	public static int toPX = 32;     // 1 Mètre dans le jeu équivaut à 32px,
	public static float toM = 1f/toPX;  // pour convertir on multiplie ou on divise 
	public static float RESOLUTION; // On ne peut pas la définir ici parce qu'elle dépend de l'OS
	
	public static int MAP_WIDTH = 20;     // Largeur de la map
	public static int MAP_HEIGHT = 15;    // Hauteur de la map
	
	public static int MAP_WIDTHpx = MAP_WIDTH * toPX;
	public static int MAP_HEIGHTpx = MAP_HEIGHT * toPX;

	public static int CAMERA_WIDTH = toPX * 15; // Largeur de la caméra. On veut afficher 15 blocs en largeur.
	public static int CAMERA_HEIGHT; // Hauteur de la caméra, s'adapte en fonction de la largeur pour avoir une résolution cohérente
	public static int HERO_VELOCITY = 300;  // Vitesse du personnage en px/s (je crois)
}

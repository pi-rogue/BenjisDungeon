package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Settings {
	
	private Button[] settings;
	
	public Settings() throws SlickException{
		
		settings = new Button[3];
		
		settings[0] = new Button(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2-150, "assets/gui/buttons/Sound.png", "sound");
		settings[1] = new Button(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2, "assets/gui/buttons/Commands.png", "commands");
		settings[2] = new Button(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2+150, "assets/gui/buttons/Return.png", "return_settings");
		
}
	
	public void render(Graphics g) {
		g.setColor(new Color(0f,0f,0f,0.45f));
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		for (Button button : settings) {
			button.render(g);
		}
	}
	
	public void update() {
		for (Button button : settings) {
			button.update();
		}}}
	
	
	
	// TODO Auto-generated constructor stub

	
	
	
	

	/*
	 * TODO : Faire une page de réglage un peu dans le même style que dans Menu.java et l'implémenter
	 * Le bouton dans le menu est déjà fait il faut juste le link (voir Button.java)
	 * 
	 * Pour l'instant les boutons sont faits de telle sorte que ce soit forcément une image mais on peut changer ça
	 * 
	 * 
	 * 
	 * Pro tip pour agrandir du texte:
	 * Dans la méthode render(Graphics g)
	 * 		g.scale(2f, 2f); // On change l'échelle du graphics
	 * 		g.drawString("le pain", x, y); // Attention aux coordonnées qui sont modifiées parce qu'on a changé l'échelle
	 * 		g.scale(0.5f, 0.5f); // Et on la remet
	 */
	


package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Menu {

	private Button[] buttons;
	
	public Menu() throws SlickException {
		buttons = new Button[3];
		buttons[0] = new Button(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2-150, "assets/gui/buttons/Continue.png", "continue");
		buttons[1] = new Button(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2, "assets/gui/buttons/Settings.png", "settings");
		buttons[2] = new Button(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2+150, "assets/gui/buttons/Exit.png", "exit");
	}
	
	public void render(Graphics g) {
		g.setColor(new Color(0f,0f,0f,0.35f));
		g.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
		for (Button button : buttons) {
			button.render(g);
		}
	}
	
	public void update() {
		for (Button button : buttons) {
			button.update();
		}
	}
	
}

package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Inventory {

	private boolean isVisible = false;

	public void render(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(Constants.SCREEN_WIDTH*0.2f, Constants.SCREEN_HEIGHT*0.2f, Constants.SCREEN_WIDTH*0.6f, Constants.SCREEN_HEIGHT*0.6f);
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	

}

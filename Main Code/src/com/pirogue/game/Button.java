package com.pirogue.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Button {

	private Image background;
	private Image selected;
	private Rectangle rect;
	private String label;
	
	public Button(int centerX, int centerY, String background, String label) throws SlickException {
		this.background = new Image(background);
		this.selected = new Image("assets/gui/buttons/selected.png");
		this.label = label;
		this.rect = new Rectangle(centerX-this.background.getWidth()/2, centerY-this.background.getHeight()/2, this.background.getWidth(), this.background.getHeight());
	}
	
	public void render(Graphics g) {
		g.drawImage(background, rect.getMinX(), rect.getMinY());
		if (rect.contains(Constants.mouseX, Constants.mouseY))
			g.drawImage(selected, rect.getMinX(), rect.getMinY());
		
	}
	
	public void execute() {
		if (label.equals("exit")) {
			Constants.container.exit();
		}
		else if (label.equals("continue")) {
			Constants.currentScreen = "running";
		}
		else if (label.equals("settings")) { // TODO: Link à la page de settings ici
			System.out.println("\n######################################################\n  Je laisse le soin à Benji de faire cette partie <3\n######################################################\n");
		}
	}
	
	public void update() {
		if (Constants.mousePressed && !Constants.mouseWasPressed && rect.contains(Constants.mouseX, Constants.mouseY))
			this.execute();
	}	
}

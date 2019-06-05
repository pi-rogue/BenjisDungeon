package com.pirogue.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.pirogue.entity.Chest;
import com.pirogue.entity.mob.FireGhost;
import com.pirogue.entity.Stairs;
import com.pirogue.entity.mob.Slime;
import com.pirogue.entity.projectiles.Fireball;
import com.pirogue.items.EmptyItem;
import com.pirogue.items.List;

public class Console {

	private int delta;
	private String arrowDir;
	public String enteredString;
	public String historic;
	public String line;
	List obj = new List();

	public Console() {
		this.enteredString = "";
		this.historic = "\n \n \n \n \n \n \n \n \n \n \n type your command";
		this.line = ">";
	}

	public void update(int delta, String arrowDir) {
		this.delta = delta;
		this.arrowDir = arrowDir;
	}

	void render(Graphics g) throws SlickException
	{
		if (Constants.inConsole) {
			g.setColor(new Color(0f,0f,0f,0.35f));
			g.fillRect(0, 0, 500, 300);
			g.setColor(Color.white);
			g.drawString(enteredString,20,270);
			g.drawString(historic,10,10);
			g.drawString(line, 8, 270);
		}
		if (Constants.debug) {
			g.drawString("delta: " + delta, 100, 10);
			g.drawString("mousePressed: " + Constants.mousePressed, Constants.SCREEN_WIDTH-500, 10);
			g.drawString("mouseX: " + Constants.mouseX, Constants.SCREEN_WIDTH-300, 10);
			g.drawString("mouseY: " + Constants.mouseY, Constants.SCREEN_WIDTH-150, 10);
			g.drawString("arrowDir: " + arrowDir, Constants.SCREEN_WIDTH/2-100, 10);
		}
	}


	void keyPressed(int key, char c) {
		if (key == Input.KEY_BACK && enteredString.length()>0) {
			enteredString = enteredString.substring(0,(enteredString.length()-1));
		}
		else if (key == Input.KEY_RETURN) {
			if (enteredString!="") this.historic += "\n"+enteredString;
			this.executeCommand(enteredString);
			this.enteredString = "";
		}
		else enteredString+=c;

		String[] commandes = historic.split("\n");
		if(commandes.length>13){
			this.historic="";
			for(int i=commandes.length-12;i<commandes.length;i++) {
				historic += "\n"+commandes[i];
			}
		}
	}


	void executeCommand(String command) {
		String[] word = command.split(" ");
		switch(word[0]) {
		case "/walid":
			this.historic += "\n# OK. OP MODE ENABLED";
			Constants.dungeon.hero.damages = 1000000;
			Constants.dungeon.hero.setLife(300);
			break;
		case "/give" :
			if (word.length>1) {
				int n=6;
				double ID;
				while((!(Constants.dungeon.hero.inventory.objects[n] instanceof EmptyItem))) {
					n++;
				}
				if (word[1].equals("empty") || word[1].equals("")) {
					break;
				}
				else {
					word[1] = word[1].replaceAll("[^0-9\\.]", "");
					ID = Double.parseDouble(word[1]);
					if(ID<200000 && (obj.Items[(int)ID])!=null) {
						//System.out.println(ID);
						Constants.dungeon.hero.inventory.objects[n] = obj.Items[(int)ID];
					}
				}
			}
			else {
				this.historic += "\n# Usage : /give <ID>";
			}
			break;

		case "/set":
			if (word.length>1) {
				switch (word[1]) {
				case "life":
					if (word.length==3 && Integer.parseInt(word[2])>=0 && Integer.parseInt(word[2])<=100) {
						Constants.dungeon.hero.setLife(Integer.parseInt(word[2]));
					}
					else this.historic += "\n# Usage : /set life <value>\n# The value must be between 0 and 100";
					break;
				}
			}
			else this.historic += "\n# Usage : /set <field> <value>";
			break;

		case "/summon":
			if (word.length>1) {
				boolean success = true;
				switch (word[1]) {
				case "chest":
				case "Chest":
					Constants.dungeon.getCurrentFloor().entities.add(new Chest(Constants.dungeon.hero.x/Constants.blockSize, Constants.dungeon.hero.y/Constants.blockSize-2, ""));
					break;
				case "slime":
				case "Slime":
					Constants.dungeon.getCurrentFloor().entities.add(new Slime(Constants.dungeon.hero.x/Constants.blockSize, Constants.dungeon.hero.y/Constants.blockSize-2, "blue"));
					break;
				case "fire_ghost":
				case "fireghost":
				case "FireGhost":
					Constants.dungeon.getCurrentFloor().entities.add(new FireGhost(Constants.dungeon.hero.x/Constants.blockSize, Constants.dungeon.hero.y/Constants.blockSize-2));
					break;
				case "fireball":
				case "Fireball":
					Constants.dungeon.getCurrentFloor().entities.add(new Fireball(Constants.dungeon.hero.x/Constants.blockSize, Constants.dungeon.hero.y/Constants.blockSize-2, 90f));
					break;
				case "stairs":
					Constants.dungeon.getCurrentFloor().entities.add(new Stairs(Constants.dungeon.hero.x/Constants.blockSize, Constants.dungeon.hero.y/Constants.blockSize-1));
					break;
				default:
					this.historic += "\n# Unknown entity";
					success = false;
				}
				if (success) this.historic += "\n# Entity successfully summoned";
			}
			else this.historic += "\n# Usage : /summon <entity>";
			break;
		}
	}
}

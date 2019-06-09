package com.pirogue.game;

import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.pirogue.entity.Entity;

public class Game extends BasicGame {

	private Dungeon dungeon;
    private Console console;
    private Menu menu;
	private int momentum;
	private Settings settings;
	private Sound sound;
	public static int test;


	public Game() {
		super("Game"); // Titre de la fenètre
	}

	public static void main(String[] args) throws SlickException {
		System.setProperty("org.lwjgl.librarypath", new File("lib/natives").getAbsolutePath()); // A laisser, pour qu'il trouve les libraries
		AppGameContainer application = new AppGameContainer(new Game(), Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, false); // WIDTH et HEIGHT correspondent à la résolution spécifiée dans les constantes
		// Settings //
		application.setFullscreen(Constants.FULLSCREEN);
		application.setTargetFrameRate(Constants.FPS_MAX);
		application.setShowFPS(Constants.SHOW_FPS);
		application.setVSync(Constants.VERTICAL_SYNC);
		application.setMaximumLogicUpdateInterval(Constants.DELTA_MAX);
        application.setIcon("src/assets/gui/icon.png");
		application.start(); // Démarre le jeu
	}

	@Override
	public void init(GameContainer container) throws SlickException {
        Constants.init();
        Constants.container = container; // On le met ici pour pouvoir y accéder de partout
        this.console = new Console();
        this.menu = new Menu();
        this.sound = new Sound();
        this.settings = new Settings();
        this.dungeon = new Dungeon();
        this.dungeon.spawnHero();
        Constants.dungeon = this.dungeon;
	}

	public void keyPressed(int key, char c) { // Se lance quand on appuie sur n'importe quelle touche
		if (Constants.currentScreen.equals("running")) {
			if (key == Constants.KEY_Console) {
				Constants.inConsole=!Constants.inConsole;
				this.console.enteredString="";
				this.console.historic=" \n \n \n \n \n \n \n \n \n \n \n \ntype your command";
			}
			else if (Constants.inConsole) { // ---------------- Si la console est ouverte
				// On transmet tous les inputs clavier à la console en filtrant certaines touches
				if (key!=Input.KEY_LSHIFT  && key!=Input.KEY_RSHIFT &&
						key!=Input.KEY_LALT && key!=Input.KEY_RALT &&
						key!=Input.KEY_CAPITAL && key!=Input.KEY_TAB &&
						key!=Input.KEY_HOME && key!=Input.KEY_END &&
						key!=Input.KEY_PRIOR && key!=Input.KEY_NEXT) console.keyPressed(key, c);
			}
			else { // ---------------- Sinon c'est le comportement normal
				if (key == Constants.KEY_DebugView) {
					Constants.debug = !Constants.debug;
				}
				else if (key == Constants.KEY_Inventory) {
					dungeon.hero.toggleInventory();
				}
			}

			if (key == Constants.KEY_Exit) { // ---------------- Dans tous les cas si c'est <escape>
				if (dungeon.hero.inInventory())	dungeon.hero.toggleInventory();
				else if (Constants.inConsole) Constants.inConsole=false;
				else Constants.currentScreen = "menu";
			}
		}
		else if (Constants.currentScreen.equals("menu")) {
			if (key == Constants.KEY_Exit) {
				Constants.currentScreen = "running";
			}
		}
		else if (Constants.currentScreen.equals("settings")) {
			if (key == Constants.KEY_Exit) {
				Constants.currentScreen = "running";
			}
		}
		else if (Constants.currentScreen.equals("sound")) {
			if (key == Constants.KEY_Exit) {
				Constants.currentScreen = "running";
			}}}


	private String arrowsDirection() { // Renvoie la direction vers laquelle le héros doit se déplacer sur une boussole
		Input input = Constants.container.getInput(); // On récupère l'input (qui permet de savoir les touches sur lesquelles on appuie)
		String directionV = ""; // Verticale
		String directionH = ""; // Horizontale
		if (input.isKeyDown(Constants.KEY_Up   )) directionV += "N";
		if (input.isKeyDown(Constants.KEY_Down )) directionV += "S";
		if (input.isKeyDown(Constants.KEY_Left )) directionH += "O";
		if (input.isKeyDown(Constants.KEY_Right)) directionH += "E";
		if (directionV.length()>1) directionV = ""; // Si on appuie sur deux directions opposées en même temps,
		if (directionH.length()>1) directionH = ""; // on ne doit afficher aucune des deux directions.
		return directionV + directionH;
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// Fonction qui gère tous les affichages, appelée automatiquement à chaque tour de boucle.
		// Tous les dessins à l'écran sont réalisés via le Graphics g (qu'on doit donc passer en paramètre).

		if (Constants.currentScreen.equals("running")) {
			dungeon.render(g);
			console.render(g);
		}
		else if (Constants.currentScreen.equals("menu")) {
			dungeon.render(g);
			menu.render(g);
		}
		else if (Constants.currentScreen.equals("settings")) {
			dungeon.render(g);
			console.render(g);
			settings.render(g);	}
		else if (Constants.currentScreen.equals("sound")) {
			dungeon.render(g);
			console.render(g);
			sound.render(g);
			}
		else {
			System.out.println("Unknown screen: " + Constants.currentScreen);
		}
	}

	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		// Fonction qui gère toutes les updates, appelée automatiquement à chaque tour de boucle.
		// La variable delta est un nombre proportionnel au temps écoulé depuis la dernière update, elle sert
		// donc à gérer les lags en prenant en compte la différence de temps.

		// -- Update mouse input -- //
		Input input = container.getInput();
		Constants.mouseWasPressed = Constants.mousePressed;
		Constants.mousePressed = input.isMouseButtonDown(0);  // Ces trois valeurs sont stoquées dans les
		Constants.mouseX = input.getMouseX();                 // constantes pour pouvoir s'en servir par la
		Constants.mouseY = input.getMouseY();                 // suite, depuis n'importe où.

		if (Constants.currentScreen.equals("running")) {
			// -- Update arrows input -- //
			String arrowsDir = arrowsDirection();
			if (Constants.inConsole) {
				dungeon.hero.setMoving(-1);
			}
			else if (arrowsDir.equals("")) {
				dungeon.hero.setMomentum(true);
				momentum++;
				if (momentum >= Constants.slideDelay) {
					dungeon.hero.setMoving(-1);
					dungeon.hero.setMomentum(false);
					momentum = 0;
				}
			}
			else {
				dungeon.hero.setMomentum(false);
				momentum=0;
				switch (arrowsDir) {
				case "N" : dungeon.hero.setMoving(0); break;
				case "NE": dungeon.hero.setMoving(1); break;
				case "E" : dungeon.hero.setMoving(2); break;
				case "SE": dungeon.hero.setMoving(3); break;
				case "S" : dungeon.hero.setMoving(4); break;
				case "SO": dungeon.hero.setMoving(5); break;
				case "O" : dungeon.hero.setMoving(6); break;
				case "NO": dungeon.hero.setMoving(7); break;
				}
			}

			// -- Update hero, mobs and debug information -- //
			console.update(delta, arrowsDir);
			dungeon.hero.update(delta);
			for(int i=0; i<dungeon.getCurrentFloor().entities.size(); i++) {
				Entity entity = dungeon.getCurrentFloor().entities.get(i);
				entity.update(delta);
				
				if (entity.vanished) {
					Constants.dungeon.getCurrentFloor().entities.remove(entity);
					i--;
				}
			}
		}
		else if (Constants.currentScreen.equals("menu")) {
			menu.update();
		}
		else if (Constants.currentScreen.equals("settings")) {
			settings.update();}

		else if (Constants.currentScreen.equals("sound")) {
			sound.update();
		}
	}
}

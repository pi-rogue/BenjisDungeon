package com.pirogue.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PiRogue extends Game implements ApplicationListener {
	public SpriteBatch batch; // Objet qui sert à dessiner
	public OrthographicCamera camera;
	public Screen gameScreen;
	public Screen mainMenuScreen; // Je l'ai pas fait mais c'est pour montrer le principe d'avoir plusieurs Screens
	
	@Override
	public void create() {
		batch = new SpriteBatch();
		camera = new OrthographicCamera();
		gameScreen = new GameScreen(this);
		setScreen(gameScreen); // En gros on a juste à faire un setScreen() pour afficher un menu ou ce qu'on veut
	}

	@Override
	public void render() { // Cette méthode s'exécute en boucle dans le programme
		super.render(); // Obligatoire, c'est là qu'on va render le Screen actuel
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE)) {Gdx.app.exit();} // On quitte si on appuie sur ESCAPE
	}
	
	@Override
	public void dispose() { // Celle là s'exécute quand on ferme la fenêtre
		//mainMenuScreen.dispose();
		gameScreen.dispose();
		batch.dispose();
		
	}
}

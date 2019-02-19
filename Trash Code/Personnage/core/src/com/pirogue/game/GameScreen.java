package com.pirogue.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;

public class GameScreen implements Screen {
	private final PiRogue game;
	private Rectangle hero; // L'avantage d'un Rectangle c'est qu'il a des fonctions qui simplifient de ouf
	private TiledMap map;
	private OrthogonalTiledMapRenderer mapRenderer;
	
	// Alors je reconnais que c'est fait de la pire des façons mais je voulais juste test un animation
	Texture heroSprite;
	Animation<TextureRegion> anim;  // anim courrante
	Animation<TextureRegion> animF; // Front
	Animation<TextureRegion> animL; // Left
	Animation<TextureRegion> animR; // Right
	Animation<TextureRegion> animB; // Back
	float stateTime; // Sert à comptabiliser le temps écouler pour savoir quelle frame doit être affichée
	
	public GameScreen(final PiRogue game) {
		this.game = game;
		game.camera.setToOrtho(false, Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT); // On définit la camera, avec la taille prévue dans Constants.java
		
		// -- Load the Map -- //
		map = new TmxMapLoader().load("map.tmx");
		mapRenderer = new OrthogonalTiledMapRenderer(map);

		// -- Load all Animations -- //
		heroSprite = new Texture(Gdx.files.internal("doggo.png"));
		int cellWidth = heroSprite.getWidth()/3;    // L'image doggo.png fait 3 colonnes
		int cellHeight = heroSprite.getHeight()/4;  // et 4 lignes
		
		TextureRegion[][] tmp = TextureRegion.split(heroSprite, cellWidth, cellHeight); // On découpe l'image
		float vitesse = 1/5f; // 5 fps
		animF = new Animation<TextureRegion>(vitesse, tmp[0]);  // Front //
		animL = new Animation<TextureRegion>(vitesse, tmp[1]);  // Left  //
		animR = new Animation<TextureRegion>(vitesse, tmp[2]);  // Right //
		animB = new Animation<TextureRegion>(vitesse, tmp[3]);  // Back  //
		anim = animF; // Current animation
		stateTime = 0f;

		// -- Load and define hero's position -- //
		hero = new Rectangle();
		hero.x = Constants.MAP_WIDTHpx/2;
		hero.y = Constants.MAP_HEIGHTpx/2;
		hero.width = cellWidth;
		hero.height = cellHeight;
	}
	
	@Override
	public void render(float delta) { // C'est ici que presque tout le jeu va se passer
		Gdx.gl.glClearColor(1f, 1f, 1f, 1); // Couleur blanche (trois premiers nombres, le 4eme je me souviens plus)
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);  // On efface l'écran avec cette couleur
		game.camera.position.set(hero.x + hero.width/2, hero.y + hero.height/2, 0); // x,y (et z pas le choix) de la camera qu'on recentre sur le héros à chaque fois
		game.camera.update();
		game.batch.setProjectionMatrix(game.camera.combined);  // Askip c'est pour dire au batch d'utiliser le système d'unités de la camera
		
		// -- Draw map -- //
		mapRenderer.setView(game.camera);  // A peu près pareil mais pour dessiner la map
		mapRenderer.render();
		
		// -- Animation and hero render -- //
		TextureRegion currentFrame = anim.getKeyFrame(stateTime, true); // On récupère la frame à afficher en fonction de stateTime

		// Pour la petite explication OPEN_GL (qui est utilisé pour toute la partie graphique) aime pas trop dessiner bcp de trucs,
		// du coup on met tout ce qu'on veut dessiner entre batch.begin() et batch.end(), et le batch va tout balancer d'un seul coup
		// à OPEN_GL, ça améliore les perfs.
		game.batch.begin();
		game.batch.draw(currentFrame, hero.x, hero.y);
		game.batch.end();

		// -- Input processing -- // Protip: Appuier sur toutes les flèches en même temps pour un jeu de jambes hors du commun
		if (Gdx.input.isKeyPressed(Input.Keys.UP) && hero.y < Constants.MAP_HEIGHTpx - hero.getHeight()) {
			stateTime += delta; // C'est fait à l'arrache mais en mettant ça ici ça permet de mettre en pause l'anim quand on appuie sur rien
			anim = animB; // On change l'animation courrante
			hero.y += Constants.HERO_VELOCITY * delta; // jsp exactement pourquoi on multiplie par delta, il me semble que c'est le temps écoulé depuis le dernier render (parce qu'ils doivent pas se faire à intervalles réguliers ou une connerie comme ça youhou ce commentaire est extrêmement long pour rien c'est génial).
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN) && hero.y > 0) {
			stateTime += delta;
			anim = animF;
			hero.y -= Constants.HERO_VELOCITY * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && hero.x > 0) {
			stateTime += delta;
			anim = animL;
			hero.x -= Constants.HERO_VELOCITY * delta;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && hero.x < Constants.MAP_WIDTHpx - hero.getWidth()) {
			stateTime += delta;
			anim = animR;
			hero.x += Constants.HERO_VELOCITY * delta;
		}
		
	}
	
	@Override
	public void dispose() {  // Quand on ferme la fenêtre, généralement on clean surtout les Textures qu'on a chargées
		heroSprite.dispose();
	}

	@Override
	public void show() {}   // Méthode appelée quand ce Screen est affiché 

	@Override
	public void hide() {}   // Et ça c'est l'inverse

	@Override
	public void resize(int width, int height) {}

	@Override
	public void pause() {}

	@Override
	public void resume() {}
}


// Supiot corp ©
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private TankGame tankGame;
	public Texture tankImg1;
	public Texture tankImg2;
	public Texture background;
	private World world;
	private Player1 player1;
	private Player2 player2;
	private int x;
	private int y;
	
	public GameScreen(TankGame tankGame) {
        this.tankGame = tankGame;
        tankImg1 = new Texture("player.png");
        tankImg2 = new Texture("player2.png");
        world = new World(tankGame);
        player1 = world.getPlayer1();
        player2 = world.getPlayer2();
        background = new Texture("background.jpg");
        x = 100;
        y = 100;
    }
	
	 @Override
	 public void render(float delta) {
		 update(delta);
		 Gdx.gl.glClearColor(0, 0, 0, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 SpriteBatch batch = tankGame.batch;
	     batch.begin();
	     batch.draw(background, 0, 0);
	     Vector2 pos_player1 = player1.getPosition();
	     batch.draw(tankImg1, pos_player1.x, pos_player1.y);
	     Vector2 pos_player2 = player2.getPosition();
	     batch.draw(tankImg2, pos_player2.x, pos_player2.y);
	     batch.end();
	 }
	 
	 public void update(float delta) {
		 if(Gdx.input.isKeyPressed(Keys.A)) {
			 player1.move(player1.DIRECTION_LEFT);
	     }
	     if(Gdx.input.isKeyPressed(Keys.D)) {
	    	 player1.move(player1.DIRECTION_RIGHT);
	     }
	     if(Gdx.input.isKeyPressed(Keys.W)) {
			 player1.move(player1.DIRECTION_UP);
	     }
	     if(Gdx.input.isKeyPressed(Keys.S)) {
	    	 player1.move(player1.DIRECTION_DOWN);
	     }
	     if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			 player2.move(player2.DIRECTION_LEFT);
	     }
	     if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
	    	 player2.move(player2.DIRECTION_RIGHT);
	     }
	     if(Gdx.input.isKeyPressed(Keys.UP)) {
			 player2.move(player2.DIRECTION_UP);
	     }
	     if(Gdx.input.isKeyPressed(Keys.DOWN)) {
	    	 player2.move(player2.DIRECTION_DOWN);
	     }
	 }
	
 
}
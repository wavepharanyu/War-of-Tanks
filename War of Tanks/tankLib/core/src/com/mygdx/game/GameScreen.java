package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private TankGame tankGame;
    WorldRenderer worldRenderer;
   // private SpriteBatch batch;
    public Player1 player1;
	public Player2 player2;
	private World world;
	
	public GameScreen(TankGame tankGame) {
		this.setTankGame(tankGame);
        world = new World(tankGame);
        worldRenderer = new WorldRenderer(tankGame, world);
        player1 = world.getPlayer1();
        player2 = world.getPlayer2();      
    }
	
	 @Override
	 public void render(float delta) {
		 Gdx.gl.glClearColor(0, 0, 0, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 update(delta);
	     worldRenderer.render(delta);
		 world.update(delta);
	 }
	 
	public void updatePlayer1(float delta) {
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
	}
	
	public void updatePlayer2(float delta) {
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
	public void update(float delta) {
		updatePlayer1(delta);
		updatePlayer2(delta);
		 /*Vector2 pos_player1 = player1.getPosition();
		 if (pos_player1.x >= 0 && pos_player1.x <= 1024) {
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
		 }*/
	}
	 
	 public TankGame getTankGame() {
		return tankGame;
		}
	 public void setTankGame(TankGame tankGame) {
		this.tankGame = tankGame; 
	 }
}
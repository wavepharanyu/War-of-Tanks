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
	World world;
	
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
		Vector2 posPlayer1 = player1.getPosition();
		if(posPlayer1.x >=0) {
			if(Gdx.input.isKeyPressed(Keys.A)) {
				player1.move(player1.DIRECTION_LEFT);
			}
		}
		if (posPlayer1.x <= 960) { 
			if(Gdx.input.isKeyPressed(Keys.D)) {
				player1.move(player1.DIRECTION_RIGHT);
			}
		}
	}
	
	public void updatePlayer2(float delta) {
		Vector2 posPlayer2 = player2.getPosition();
		if(posPlayer2.x >=0) {
			if(Gdx.input.isKeyPressed(Keys.LEFT)) {
				player2.move(player2.DIRECTION_LEFT);
			}
		}
		if(posPlayer2.x <=960) {
			if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
				player2.move(player2.DIRECTION_RIGHT);
			}
		}
	}
	public void update(float delta) {
			updatePlayer1(delta);
			updatePlayer2(delta);	
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			if(world.gameState == 0) {
				world.gameState = 1;
			}
			
			/*if(world.gameState == 2 || world.gameState == 3) {
				world.gameState = 1;
				world.resetStage();	
			}*/
		}
	}
	 
	 public TankGame getTankGame() {
		return tankGame;
		}
	 public void setTankGame(TankGame tankGame) {
		this.tankGame = tankGame; 
	 }
}
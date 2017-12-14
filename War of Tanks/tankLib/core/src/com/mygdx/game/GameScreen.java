package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private TankGame tankGame;
	public Texture tankImg;
	public Texture background;
	private World world;
	private Player1 player1;
	private Player2 player2;
	
	public GameScreen(TankGame tankGame) {
        this.tankGame = tankGame;
        tankImg = new Texture("player.png");
        world = new World(tankGame);
        player1 = world.getPlayer1();
        player2 = world.getPlayer2();
        background = new Texture("background.jpg");
    }
	
	 @Override
	 public void render(float delta) {
		 SpriteBatch batch = tankGame.batch;
	     batch.begin();
	     batch.draw(background, 0, 0);
	     Vector2 pos_player1 = player1.getPosition();
	     batch.draw(tankImg, pos_player1.x, pos_player1.y);
	     Vector2 pos_player2 = player2.getPosition();
	     batch.draw(tankImg, pos_player2.x, pos_player2.y);
	     batch.end();
	 }
 
}
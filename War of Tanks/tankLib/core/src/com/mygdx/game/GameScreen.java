package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private TankGame tankGame;
	public Texture tankImg;
	private World world;
	private Player player;
	
	public GameScreen(TankGame tankGame) {
        this.tankGame = tankGame;
        tankImg = new Texture("pacman.png");
        world = new World(tankGame);
        player = world.getPlayer();
    }
	
	 @Override
	 public void render(float delta) {
		 SpriteBatch batch = tankGame.batch;
	     batch.begin();
	     Vector2 pos_player = player.getPosition();
	     batch.draw(tankImg, pos_player.x, pos_player.y);
	     batch.end();
	 }
 
}
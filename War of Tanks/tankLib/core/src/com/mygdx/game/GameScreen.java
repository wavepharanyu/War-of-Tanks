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
	public Texture bulletImg1;
	public Texture bulletImg2;
	public Texture background;
	public Texture boxImg;
	private World world;
	private Player1 player1;
	private Player2 player2;
	private int x;
	private int y;
	private Bullet1 bullet1;
	private Bullet2 bullet2;
	
	public GameScreen(TankGame tankGame) {
        this.tankGame = tankGame;
        tankImg1 = new Texture("player.png");
        tankImg2 = new Texture("player2.png");
        bulletImg1 = new Texture("pacman.png");
        bulletImg2 = new Texture("pacman.png");
        boxImg = new Texture("box.png");
        world = new World(tankGame);
        player1 = world.getPlayer1();
        player2 = world.getPlayer2();
        background = new Texture("background.jpg");
        bullet1 = new Bullet1(player1);
        bullet2 = new Bullet2(player2);
        
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
	     batch.draw(bulletImg1,bullet1.getPosition().x,bullet1.getPosition().y);
	     batch.draw(bulletImg2,bullet2.getPosition().x,bullet2.getPosition().y);
	     batch.end();
	 }
	 
	 public void update(float delta) {
		 Vector2 pos_player1 = player1.getPosition();
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
			 if(Gdx.input.isKeyJustPressed(Keys.F)) {		
				 bullet1.setCheck(1);
			 }
			 if(Gdx.input.isKeyJustPressed(Keys.L)) {		
				 bullet2.setCheck(1);
			 }
			 bullet1.update();
			 bullet2.update();
		 }
	 }
	
 
}
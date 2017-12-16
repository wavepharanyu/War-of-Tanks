package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;
 
public class GameScreen extends ScreenAdapter {
	private TankGame tankGame;
	public Texture tankImg1;
	public Texture tankImg2;
	public Texture bulletImg1;
	public Texture bulletImg2;
	public Texture background;
	public Texture boxImg;
	public Texture heartImg;
	private World world;
	private Player1 player1;
	private Player2 player2;
	private int x;
	private int y;
	private Bullet1 bullet1;
	private List<Bullet1> bullet1List;
	private Bullet2 bullet2;
	private List<Bullet2> bullet2List;
	private Box box1;
	private Box2 box2;
	private Heart heart;
	private boolean bullet1IsRemove = true;
	private boolean bullet2IsRemove = true;
	private int times = 0;
	
	public GameScreen(TankGame tankGame) {
        this.tankGame = tankGame;
        tankImg1 = new Texture("player.png");
        tankImg2 = new Texture("player2.png");
        bulletImg1 = new Texture("rocket.png");
        bulletImg2 = new Texture("rocket2.png");
        boxImg = new Texture("box2.png");
        heartImg = new Texture("heart.png");
        world = new World(tankGame);
        player1 = world.getPlayer1();
        player2 = world.getPlayer2();
        box1 = world.getBox1();
        box2 = world.getBox2();
        heart = world.getHeart();
        background = new Texture("background.jpg");
        bullet1 = new Bullet1(player1);
        bullet2 = new Bullet2(player2);
        bullet1List = new ArrayList();
		bullet1List.add(bullet1);
		bullet2List = new ArrayList();
		bullet2List.add(bullet2);
        
    }
	
	 @Override
	 public void render(float delta) {
		 update(delta);
		 Gdx.gl.glClearColor(0, 0, 0, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		 SpriteBatch batch = tankGame.batch;
	     batch.begin();
	     batch.draw(background, 0, 0);
	     Vector2 posPlayer1 = player1.getPosition();
	     batch.draw(tankImg1, posPlayer1.x, posPlayer1.y);
	     Vector2 posPlayer2 = player2.getPosition();
	     Vector2 posBox1 = box1.getPosition();
	     Vector2 posBox2 = box2.getPosition();
	     Vector2 posHeart = heart.getPosition();
	     batch.draw(tankImg2, posPlayer2.x, posPlayer2.y);
	     for(int i = 0; i < bullet1List.size(); i++) {
	    	if(bullet1IsRemove == false)
	    		batch.draw(bulletImg1,bullet1List.get(i).getPosition().x,bullet1List.get(i).getPosition().y);
	        }
	     for(int i = 0; i < bullet2List.size(); i++) {
	    	if(bullet2IsRemove == false)
	    		batch.draw(bulletImg2,bullet2List.get(i).getPosition().x,bullet2List.get(i).getPosition().y);
	        }
	     batch.draw(boxImg,posBox1.x,posBox1.y);
	     batch.draw(boxImg,posBox2.x,posBox2.y);
	     if(times >= 50) {
	    	 batch.draw(heartImg,posHeart.x,posHeart.y);
	     }
	     batch.end();
	 }
	 
	 public void update(float delta) {
		 Vector2 pos_player1 = player1.getPosition();
		 times += 1;
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
			 if (bullet1IsRemove == true) {
				 if(Gdx.input.isKeyJustPressed(Keys.F)) {		
					 bullet1List.get(bullet1List.size()-1).setCheck(1);
					 bullet1List.add(new Bullet1(player1));
					 bullet1IsRemove = false;
				 }
			 }
			 if (bullet1IsRemove == true) {
				 if(Gdx.input.isKeyJustPressed(Keys.L)) {		
					 bullet2List.get(bullet2List.size()-1).setCheck(1);
					 bullet2List.add(new Bullet2(player2));
				 }
			 }
			 for(int i=0;i<bullet1List.size();i++) {
					bullet1List.get(i).update();
					if(bullet1List.get(i).getPosition().y>1024) {
						bullet1List.remove(i);
						bullet1IsRemove = true;
					}
				}
			 
			 for(int i=0;i<bullet2List.size();i++) {
					bullet2List.get(i).update();
					if(bullet2List.get(i).getPosition().y>0) {
						bullet2List.remove(i);
						bullet2IsRemove = true;
					}
				}
			 if(Intersector.overlaps(player1.getRectangle(),heart.getRectangle()))
					System.out.println("overlap");			 
		 }
	 }
	
 
}
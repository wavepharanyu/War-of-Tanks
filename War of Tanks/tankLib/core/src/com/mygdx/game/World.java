package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class World {
	private WorldRenderer worldrenderer;
	private Player1 player1;
	private Player2 player2;
	private Box box1;
	private Box2 box2;
	private Heart heart;
	private Doublebullet doubleBullet;
	private TankGame tankGame;
	private int times = 0;
	public Bullet1 bullet1;
	public Bullet2 bullet2;
	private boolean bullet1IsRemove = true;
	private boolean bullet2IsRemove = true;
	private boolean heartIsRemove = false;
	private boolean doubleBulletIsRemove = false;
	public Texture bulletImg1;
	public Texture bulletImg2;
	
	World(TankGame tankGame){
		this.setTankGame(tankGame);
		player1 = new Player1(512,100);
		player2 = new Player2(512,850);
		bullet1 = new Bullet1(512,-100);
		bullet1 = new Bullet1(512,-1100);
		box1 = new Box();
		box2 = new Box2();
		heart = new Heart();
		doubleBullet = new Doublebullet();
		bulletImg1 = new Texture("rocket.png");
	    bulletImg2 = new Texture("rocket2.png");
	}
	Player1 getPlayer1() {
		return player1;
	}
	
	Player2 getPlayer2() {
		return player2;
	}
	
	Bullet1 getBullet1() {
		return bullet1;
	}
	
	Bullet2 getBullet2() {
		return bullet2;
	}
	
	Box getBox1() {
		return box1;
	}
	
	Box2 getBox2() {
		return box2;
	}
	
	Heart getHeart() {
		return heart;
	}
	
	Doublebullet getDoublebullet() {
		return doubleBullet;
	}
	
	public void updateBullet1(float delta) {
		if (bullet1IsRemove == true) {
			if(Gdx.input.isKeyJustPressed(Keys.F)) {
				bullet1.getPosition().set(512,100);
				bullet1IsRemove = false;
				}
			}
			
		if(bullet1.getPosition().y >= 100) {
			bullet1.move();
		}
			 
		if(bullet1.getPosition().y>1024) {
			bullet1.getPosition().set(512,-100);
			bullet1IsRemove = true;
		}
	}
	
	public void updateBullet2(float delta) {
		if (bullet2IsRemove == true) {
			if(Gdx.input.isKeyJustPressed(Keys.L)) {
				bullet2.getPosition().set(512,850);
				bullet2IsRemove = false;
				}
			}
			
		if(bullet2.getPosition().y <= 850) {
			bullet2.move();
		}
			 
		if(bullet2.getPosition().y < 0) {
			bullet2.getPosition().set(512,-1100);
			bullet2IsRemove = true;
		}
	}
	public void update(float delta) {	
		 times += 1;
		updateBullet1(delta);
		if(Intersector.overlaps(player1.getRectangle(),heart.getRectangle())) {
			heart.getPosition().set(1024,1024);	 
			heartIsRemove = true;
		}
		if(Intersector.overlaps(player1.getRectangle(),doubleBullet.getRectangle())) {
			doubleBullet.getPosition().set(1024,1024);	 
			doubleBulletIsRemove = true;
		 }
		if(times % 50 == 0 && heartIsRemove == true) {
			heart.ranPos();
		 	heart.updateRecPos();	
		 	heartIsRemove = false;
		 }
		if(times % 100 == 0 && doubleBulletIsRemove == true) {
			doubleBullet.ranPos();
			doubleBullet.updateRecPos();	
			doubleBulletIsRemove = false;
		 }
	}
	public TankGame getTankGame() {
		return tankGame;
		}
	public void setTankGame(TankGame tankGame) {
		this.tankGame = tankGame;
	}
}

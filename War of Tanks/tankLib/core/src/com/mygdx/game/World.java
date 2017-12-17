package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Vector2;

public class World {
	private WorldRenderer worldrenderer;
	public Player1 player1;
	public Player2 player2;
	private Box box1;
	private Box2 box2;
	private Heart heart;
	private Fastbullet fastBullet;
	private TankGame tankGame;
	private int heartTimes = 0;
	private int fastbullTimes = 0;
	public Bullet1 bullet1;
	public Bullet1 bullet2;
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
		bullet2 = new Bullet1(512,1100);
		box1 = new Box();
		box2 = new Box2();
		heart = new Heart();
		fastBullet = new Fastbullet();
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
		
	Bullet1 getBullet2() {
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
	
	Fastbullet getFastbullet() {
		return fastBullet;
	}
	
	public void updateBullet1(float delta) {
		if (bullet1IsRemove == true) {
			if(Gdx.input.isKeyJustPressed(Keys.F)) {
				bullet1.getPosition().set(player1.getPosition().x,player1.getPosition().y);
				bullet1IsRemove = false;
				}
			}
			
		if(bullet1.getPosition().y >= 100) {
			bullet1.moveUp();
		}
			 
		if(bullet1.getPosition().y>1024) {
			bullet1.getPosition().set(player1.getPosition().x,-100);
			bullet1IsRemove = true;
		}
		
		if(Intersector.overlaps(bullet1.getRectangle(),heart.getRectangle())) {
			heart.getPosition().set(1024,1024);	 
			bullet1.getPosition().set(player1.getPosition().x,-100);
			heart.updateRecPos();	
			bullet1.updateRecPos();
			heartIsRemove = true;
			bullet1IsRemove = true;
		}
		
		if(Intersector.overlaps(bullet1.getRectangle(),fastBullet.getRectangle())) {
			fastBullet.getPosition().set(1024,1024);	
			bullet1.getPosition().set(player1.getPosition().x,-100);
			fastBullet.updateRecPos();
			bullet1.updateRecPos();
			doubleBulletIsRemove = true;
			bullet1IsRemove = true;
		 }
		
		if(Intersector.overlaps(bullet1.getRectangle(),box1.getRectangle()) || Intersector.overlaps(bullet1.getRectangle(),box2.getRectangle())) {	
			bullet1.getPosition().set(player1.getPosition().x,-100);
			bullet1.updateRecPos();
			bullet1IsRemove = true;
		 }
		
	}
	
	public void updateBullet2(float delta) {
		if (bullet2IsRemove == true) {
			if(Gdx.input.isKeyJustPressed(Keys.L)) {
				bullet2.getPosition().set(player2.getPosition().x,player2.getPosition().y);
				bullet2IsRemove = false;
				}
			}
			
		if(bullet2.getPosition().y <= 850) {
			bullet2.moveDown();
		}
			 
		if(bullet2.getPosition().y < 0) {
			bullet2.getPosition().set(player1.getPosition().x,1100);
			bullet2IsRemove = true;
		}
		
		if(Intersector.overlaps(bullet2.getRectangle(),heart.getRectangle())) {
			heart.getPosition().set(1024,1024);	 
			bullet2.getPosition().set(player1.getPosition().x,1100);
			heart.updateRecPos();	
			bullet2.updateRecPos();
			heartIsRemove = true;
			bullet2IsRemove = true;
		}
		
		if(Intersector.overlaps(bullet2.getRectangle(),fastBullet.getRectangle())) {
			fastBullet.getPosition().set(1024,1024);	 
			bullet2.getPosition().set(player1.getPosition().x,1100);
			fastBullet.updateRecPos();
			bullet2.updateRecPos();
			doubleBulletIsRemove = true;
			bullet2IsRemove = true;
		 }
		
		if(Intersector.overlaps(bullet2.getRectangle(),box1.getRectangle()) || Intersector.overlaps(bullet2.getRectangle(),box2.getRectangle())) {	
			bullet2.getPosition().set(player2.getPosition().x,1100);
			bullet2.updateRecPos();
			bullet2IsRemove = true;
		 }
	}
	public void update(float delta) {	
		heartTimes += 1;
		fastbullTimes += 1;
		updateBullet1(delta);
		updateBullet2(delta);

		if(Intersector.overlaps(bullet1.getRectangle(),bullet2.getRectangle())) {
			bullet1.getPosition().set(player1.getPosition().x,-100);
			bullet2.getPosition().set(player1.getPosition().x,1100);
			bullet1.updateRecPos();
			bullet2.updateRecPos();
			bullet1IsRemove = true;
			bullet2IsRemove = true;
		 }
		
		if(heartTimes % 300 == 0 ) {
			heart.ranPos();
		 	heart.updateRecPos();	
		 	heartIsRemove = false;
		 	heartTimes = 0;
		 }
		if(fastbullTimes % 600 == 0) {
			fastBullet.ranPos();
			fastBullet.updateRecPos();	
			doubleBulletIsRemove = false;
			fastbullTimes = 0;
		 }
	}
	public TankGame getTankGame() {
		return tankGame;
		}
	public void setTankGame(TankGame tankGame) {
		this.tankGame = tankGame;
	}
}

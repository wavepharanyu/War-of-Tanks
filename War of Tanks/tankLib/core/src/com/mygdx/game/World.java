package com.mygdx.game;

import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;

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
		this.tankGame = tankGame;
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
	
	public void update(float delta) {	
		 times += 1;
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
	public void setGoawayGame(TankGame tankGame) {
		this.tankGame = tankGame;
	}
}

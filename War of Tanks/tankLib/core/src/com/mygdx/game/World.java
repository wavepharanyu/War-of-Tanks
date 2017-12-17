package com.mygdx.game;

import java.util.Random;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Intersector;


public class World {;
	public Player1 player1;
	public Player2 player2;
	private Box box1;
	private Box box2;
	private Heart heart;
	private Fastbullet fastBullet;
	private TankGame tankGame;
	private int heartTimes = 0;
	private int fastbullTimes = 0;
	public Bullet bullet1;
	public Bullet bullet2;
	private Life life1;
	private Life life2;
	private boolean bullet1IsRemove = true;
	private boolean bullet2IsRemove = true;
	public boolean heartIsRemove = false;
	public boolean doubleBulletIsRemove = false;
	public Texture bulletImg1;
	public Texture bulletImg2;
	private Random ranX = new Random();
	private Random ranY = new Random();
	public int lifePlayer1 = 3;
	public int lifePlayer2 = 3;
	public int gameState = 0;
	
	World(TankGame tankGame){
		this.tankGame = tankGame;
		player1 = new Player1(512,100);
		player2 = new Player2(512,850);
		bullet1 = new Bullet(512,-100);
		bullet2 = new Bullet(512,1100);
		box1 = new Box(ranX.nextInt(650)+100,ranY.nextInt(215)+210);
		box2 = new Box(ranX.nextInt(650)+100,ranY.nextInt(145)+590);
		heart = new Heart();
		life1 = new Life(880,10);
		life2 = new Life(10,950);
		fastBullet = new Fastbullet();
	}
	
	Player1 getPlayer1() {
		return player1;
	}
	
	Player2 getPlayer2() {
		return player2;
	}
	
	Bullet getBullet1() {
		return bullet1;
	}
		
	Bullet getBullet2() {
		return bullet2;
	}
	
	Box getBox1() {
		return box1;
	}
	
	Box getBox2() {
		return box2;
	}
	
	Heart getHeart() {
		return heart;
	}
	
	Fastbullet getFastbullet() {
		return fastBullet;
	}
	
	Life getLife1() {
		return life1;
	}
	
	Life getLife2() {
		return life2;
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
			if(lifePlayer1 < 3)
				lifePlayer1 += 1;
			heartIsRemove = true;
			bullet1IsRemove = true;
		}
		
		if(Intersector.overlaps(bullet1.getRectangle(),fastBullet.getRectangle())) {
			fastBullet.getPosition().set(1024,1024);	
			bullet1.getPosition().set(player1.getPosition().x,-100);
			fastBullet.updateRecPos();
			bullet1.updateRecPos();
			bullet1.SPEED += 5;
			doubleBulletIsRemove = true;
			bullet1IsRemove = true;
		 }
		
		if(Intersector.overlaps(bullet1.getRectangle(),box1.getRectangle()) || Intersector.overlaps(bullet1.getRectangle(),box2.getRectangle())) {	
			bullet1.getPosition().set(player1.getPosition().x,-100);
			bullet1.updateRecPos();
			bullet1IsRemove = true;
		 }
		
		if(Intersector.overlaps(bullet1.getRectangle(),player2.getRectangle())) {	
			bullet1.getPosition().set(player1.getPosition().x,-100);
			bullet1.updateRecPos();
			bullet1IsRemove = true;
			lifePlayer2 -= 1;
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
			if(lifePlayer2 < 3)
				lifePlayer2 += 1;
			heartIsRemove = true;
			bullet2IsRemove = true;
		}
		
		if(Intersector.overlaps(bullet2.getRectangle(),fastBullet.getRectangle())) {
			fastBullet.getPosition().set(1024,1024);	 
			bullet2.getPosition().set(player1.getPosition().x,1100);
			fastBullet.updateRecPos();
			bullet2.updateRecPos();
			bullet2.SPEED += 5;
			doubleBulletIsRemove = true;
			bullet2IsRemove = true;
		 }
		
		if(Intersector.overlaps(bullet2.getRectangle(),box1.getRectangle()) || Intersector.overlaps(bullet2.getRectangle(),box2.getRectangle())) {	
			bullet2.getPosition().set(player2.getPosition().x,1100);
			bullet2.updateRecPos();
			bullet2IsRemove = true;
		 }
		
		if(Intersector.overlaps(bullet2.getRectangle(),player1.getRectangle())) {	
			bullet2.getPosition().set(player2.getPosition().x,1100);
			bullet2.updateRecPos();
			bullet2IsRemove = true;
			lifePlayer1 -= 1;
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
		if(lifePlayer1 == 0)
			gameState = 3;
		if(lifePlayer2 == 0)
			gameState = 2;
	}
}

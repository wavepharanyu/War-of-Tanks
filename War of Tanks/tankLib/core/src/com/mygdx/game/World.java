package com.mygdx.game;

import com.badlogic.gdx.math.Intersector;

public class World {
	private Player1 player1;
	private Player2 player2;
	private Box box1;
	private Box2 box2;
	private Heart heart;
	private TankGame tankGame;
	
	
	World(TankGame tankGame){
		this.tankGame = tankGame;
		
		player1 = new Player1(512,100);
		player2 = new Player2(512,850);
		box1 = new Box();
		box2 = new Box2();
		heart = new Heart();
	}
	Player1 getPlayer1() {
		return player1;
	}
	
	Player2 getPlayer2() {
		return player2;
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
}

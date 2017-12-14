package com.mygdx.game;

public class World {
	private Player1 player1;
	private Player2 player2;
	private TankGame tankGame;
	
	World(TankGame tankGame){
		this.tankGame = tankGame;
		
		player1 = new Player1(512,100);
		player2 = new Player2(512,850);
	}
	Player1 getPlayer1() {
		return player1;
	}
	
	Player2 getPlayer2() {
		return player2;
	}
}

package com.mygdx.game;

public class World {
	private Player player;
	private TankGame tankGame;
	
	World(TankGame tankGame){
		this.tankGame = tankGame;
		
		player = new Player(100,100);
	}
	Player getPlayer() {
		return player;
	}
}

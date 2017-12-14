package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet2 {
	private Vector2 position;
	private int check = 0;
	private Player2 player2;
	
	public Bullet2(Player2 player2) {
		this.player2 = player2;
		position = new Vector2(player2.getPosition().x,player2.getPosition().y);
	}
	public Vector2 getPosition() {
		return position;
	}
	public void  setCheck(int y){
		check = y;
	}
	public void update() {
		if(check == 1)
			position.y -= 10;
		else
			position.x =  player2.getPosition().x;
	}
}

package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Bullet1 {
	private Vector2 position;
	private int check = 0;
	private Player1 player1;
	
	public Bullet1(Player1 player1) {
		this.player1 = player1;
		position = new Vector2(player1.getPosition().x,player1.getPosition().y);
	}
	public Vector2 getPosition() {
		return position;
	}
	public void  setCheck(int y){
		check = y;
	}
	public void update() {
		if(check == 1)
			position.y+=10;
		else
			position.x =  player1.getPosition().x;
	}
}

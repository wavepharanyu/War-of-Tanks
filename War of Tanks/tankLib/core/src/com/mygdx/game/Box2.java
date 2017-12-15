package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Box2 {
	private Vector2 position;
	private Random ranX = new Random();
	private Random ranY = new Random();

	public int ranPosX(	) {
		return ranX.nextInt(650)+100;
	}
	
	public int ranPosY() {
		return ranY.nextInt(300)+500;
	}
	
	public Box2() {
		position = new Vector2(ranPosX(),ranPosY());
	}
	
	public Vector2 getPosition() {
		return position;
	}
}


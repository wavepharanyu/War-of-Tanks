package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Heart {
	private Vector2 position;
	private Random ranX = new Random();
	private Random ranY = new Random();
	private Rectangle rectangle;
	public int width;
    public int height;

	public int ranPosX(	) {
		return ranX.nextInt(650)+100;
	}
	
	public int ranPosY() {
		return ranY.nextInt(312)+200;
	}
	
	public Heart() {
		position = new Vector2(ranPosX(),ranPosY());
		width = 70;
        height = 70;
		rectangle = new Rectangle(ranPosX(),ranPosY(),width,height);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getRectangle() {
	    return rectangle;
	}
	
	public void move() {
		rectangle.setPosition(position.x,position.y);
	}
	
}


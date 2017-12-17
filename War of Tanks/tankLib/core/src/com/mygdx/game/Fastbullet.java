package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Fastbullet {
	private Vector2 position;
	private Random ranX = new Random();
	public int x;
	public int y;
	private Rectangle rectangle;
	public int width;
    public int height;

	public void ranPos() {
		position.x = ranX.nextInt(650)+100;
		position.y = 512;
	}
	
	
	public Fastbullet() {
		position = new Vector2(x,y);
		ranPos();
		width = 64;
        height = 64;
		rectangle = new Rectangle(position.x,position.y,width,height);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getRectangle() {
	    return rectangle;
	}
	
	public void updateRecPos() {
		rectangle.setPosition(position.x,position.y);
	}
}

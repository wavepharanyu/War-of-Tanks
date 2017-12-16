package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Box {
	private Vector2 position;
	private Random ranX = new Random();
	private Random ranY = new Random();
	public int x;
	public int y;
	private Rectangle rectangle;
	public int width;
    public int height;
	
	public void ranPos() {
		position.x = ranX.nextInt(650)+100;
		position.y = ranY.nextInt(269)+210;
	}
	
	public Box() {
		position = new Vector2(x,y);
		ranPos();
		width = 280;
        height = 85;
		rectangle = new Rectangle(position.x,position.y,width,height);
	}
	
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getRectangle() {
	    return rectangle;
	}
}
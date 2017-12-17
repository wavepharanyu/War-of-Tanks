package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bullet1 {
	private Vector2 position;
	private Rectangle rectangle;
	public int width;
    public int height;
    public int SPEED = 10;
	
	public Bullet1(int x, int y) {
		position = new Vector2(x,y);
		width = 35;
        height = 40;
		rectangle = new Rectangle(position.x,position.y,width,height);
	}
	public Vector2 getPosition() {
		return position;
	}
	
	public Rectangle getRectangle() {
	    return rectangle;
	}
	
	public void move() {
		position.y += SPEED;
		rectangle.setPosition(position.x,position.y);
	}
}

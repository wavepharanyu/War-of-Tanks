package com.mygdx.game;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Box {
	private Vector2 position;
	private Rectangle rectangle;
	public int width;
    public int height;
		
	public Box(int x, int y) {
		position = new Vector2(x,y);
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
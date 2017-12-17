package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	WorldRenderer worldrenderer;
	private TankGame tankGame;
	private World world;
	public Texture tankImg1;
	public Texture tankImg2;
	public Texture bulletImg1;
	public Texture bulletImg2;
	public Texture background;
	public Texture boxImg;
	public Texture heartImg;
	public Texture doubleBulletImg;
	private Player1 player1;
	private Player2 player2;
	private int x;
	private int y;
	private Bullet1 bullet1;
	private Bullet2 bullet2;
	private Box box1;
	private Box2 box2;
	private Heart heart;
	private Doublebullet doubleBullet;
	private int times = 0;
	
	public WorldRenderer(TankGame tankGame,World world) {
		this.tankGame = tankGame;
		this.world = world;
		tankImg1 = new Texture("player1.png");
        tankImg2 = new Texture("player2.png");
        bulletImg1 = new Texture("rocket.png");
        bulletImg2 = new Texture("rocket2.png");
        boxImg = new Texture("box.png");
        heartImg = new Texture("heart.png");
        background = new Texture("background.jpg");
        doubleBulletImg = new Texture("doublebullet.png");
        world = new World(tankGame);
	    player1 = world.getPlayer1();
	    player2 = world.getPlayer2();
	    box1 = world.getBox1();
	    box2 = world.getBox2();
	    heart = world.getHeart();
	    doubleBullet = world.getDoublebullet();
	    bullet1 = world.getBullet1();
	    bullet2 = world.getBullet2();
	}
	
	public void render (float delta) {
		SpriteBatch batch = tankGame.batch;
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    ShapeRenderer shapeRenderer = tankGame.shapeRenderer;
		batch.begin();
		batch.draw(background, 0, 0);
		Vector2 posPlayer1 = player1.getPosition();
		Vector2 posPlayer2 = player2.getPosition();
		Vector2 posBullet1 = bullet1.getPosition();
	    Vector2 posBox1 = box1.getPosition();
	    Vector2 posBox2 = box2.getPosition();
	    Vector2 posHeart = heart.getPosition();
	    Vector2 posDouble = doubleBullet.getPosition();
	    batch.draw(tankImg1, posPlayer1.x, posPlayer1.y);
		batch.draw(tankImg2, posPlayer2.x, posPlayer2.y);
		batch.draw(bulletImg1,posBullet1.x,posBullet1.y);
	    batch.draw(boxImg,posBox1.x,posBox1.y);
	    batch.draw(boxImg,posBox2.x,posBox2.y);
	    batch.draw(heartImg,posHeart.x,posHeart.y);
	    batch.draw(doubleBulletImg,posDouble.x,posDouble.y); 
	     
	    shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
	    shapeRenderer.rect(heart.getRectangle().x , heart.getRectangle().y,heart.getRectangle().width,heart.getRectangle().height);
	    shapeRenderer.rect(box1.getRectangle().x , box1.getRectangle().y,box1.getRectangle().width,box1.getRectangle().height);
	    shapeRenderer.rect(box2.getRectangle().x , box2.getRectangle().y,box2.getRectangle().width,box2.getRectangle().height);
	    shapeRenderer.rect(player2.getRectangle().x , player2.getRectangle().y,player2.getRectangle().width,player2.getRectangle().height);
	    shapeRenderer.rect(player1.getRectangle().x , player1.getRectangle().y,player1.getRectangle().width,player1.getRectangle().height);
	    shapeRenderer.rect(doubleBullet.getRectangle().x , doubleBullet.getRectangle().y,doubleBullet.getRectangle().width,doubleBullet.getRectangle().height);
	    //shapeRenderer.rect(bullet1.getRectangle().x , bullet1.getRectangle().y,bullet1.getRectangle().width,bullet1.getRectangle().height);
	    batch.end();
	    shapeRenderer.end();
		
	}
}

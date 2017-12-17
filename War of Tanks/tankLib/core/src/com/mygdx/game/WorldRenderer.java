package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class WorldRenderer {
	WorldRenderer worldrenderer;
	private TankGame tankGame;
	private World world;
	public Texture runStateImg;
	public Texture instructStateImg;
	public Texture win1StateImg;
	public Texture win2StateImg;
	public Texture tankImg1;
	public Texture tankImg2;
	public Texture bulletImg1;
	public Texture bulletImg2;
	public Texture boxImg;
	public Texture heartImg;
	public Texture fastBulletImg;
	public Texture lifeImg;
	private Player1 player1;
	private Player2 player2;
	private Bullet bullet1;
	private Bullet bullet2;
	private Box box1;
	private Box box2;
	private Heart heart;
	private Life life1;
	private Life life2;
	private Fastbullet doubleBullet;
	private BitmapFont font;
	
	public WorldRenderer(TankGame tankGame,World world) {
		this.tankGame = tankGame;
		this.world = world;
        runStateImg = new Texture("background.jpg");
        instructStateImg = new Texture("instruction.png");
        win1StateImg = new Texture("player1win.png");
        win2StateImg = new Texture("player2win.png");
		tankImg1 = new Texture("player1.png");
        tankImg2 = new Texture("player2.png");
        bulletImg1 = new Texture("rocket.png");
        bulletImg2 = new Texture("rocket2.png");
        boxImg = new Texture("box.png");
        heartImg = new Texture("heart.png");
        fastBulletImg = new Texture("fastbullet.png");
        lifeImg = new Texture("heart.png");
        font = new BitmapFont();
    	font.getData().setScale(3);
	}
	
	public void render (float delta) {
		SpriteBatch batch = tankGame.batch;
		Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	    ShapeRenderer shapeRenderer = tankGame.shapeRenderer;
		batch.begin();
		if(world.gameState == 0) {
			batch.draw(instructStateImg, 0, 0);
		}
		player1 = world.getPlayer1();
	    player2 = world.getPlayer2();
	    box1 = world.getBox1();
	    box2 = world.getBox2();
	    heart = world.getHeart();
	    doubleBullet = world.getFastbullet();
	    bullet1 = world.getBullet1();
	    bullet2 = world.getBullet2();
	    life1 = world.getLife1();
	    life2 = world.getLife2();
		Vector2 posPlayer1 = player1.getPosition();
		Vector2 posPlayer2 = player2.getPosition();
		Vector2 posBullet1 = bullet1.getPosition();
		Vector2 posBullet2 = bullet2.getPosition();
	    Vector2 posBox1 = box1.getPosition();
	    Vector2 posBox2 = box2.getPosition();
	    Vector2 posHeart = heart.getPosition();
	    Vector2 posDouble = doubleBullet.getPosition();
	    Vector2 posLife1 = life1.getPosition();
	    Vector2 posLife2 = life2.getPosition();
	    if(world.gameState == 1) {	
	    	batch.draw(runStateImg, 0, 0);
	    	batch.draw(tankImg1, posPlayer1.x, posPlayer1.y);
	    	batch.draw(tankImg2, posPlayer2.x, posPlayer2.y);
	    	batch.draw(bulletImg1,posBullet1.x,posBullet1.y);
	    	batch.draw(bulletImg2,posBullet2.x,posBullet2.y);
	    	batch.draw(boxImg,posBox1.x,posBox1.y);
	    	batch.draw(boxImg,posBox2.x,posBox2.y);
	    	batch.draw(heartImg,posHeart.x,posHeart.y);
	    	batch.draw(fastBulletImg,posDouble.x,posDouble.y);
	    	batch.draw(lifeImg,posLife1.x,posLife1.y);
	    	batch.draw(lifeImg,posLife2.x,posLife2.y);
	    	font.draw(batch, "X" + world.lifePlayer1 , 950, 50);
	    	font.draw(batch, "X" + world.lifePlayer2 , 80, 1000);
	     
	    	shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
	    	shapeRenderer.rect(heart.getRectangle().x , heart.getRectangle().y,heart.getRectangle().width,heart.getRectangle().height);
	    	shapeRenderer.rect(box1.getRectangle().x , box1.getRectangle().y,box1.getRectangle().width,box1.getRectangle().height);
	    	shapeRenderer.rect(box2.getRectangle().x , box2.getRectangle().y,box2.getRectangle().width,box2.getRectangle().height);
	    	shapeRenderer.rect(player2.getRectangle().x , player2.getRectangle().y,player2.getRectangle().width,player2.getRectangle().height);
	    	shapeRenderer.rect(player1.getRectangle().x , player1.getRectangle().y,player1.getRectangle().width,player1.getRectangle().height);
	    	shapeRenderer.rect(doubleBullet.getRectangle().x , doubleBullet.getRectangle().y,doubleBullet.getRectangle().width,doubleBullet.getRectangle().height);
	    	shapeRenderer.rect(bullet1.getRectangle().x , bullet1.getRectangle().y,bullet1.getRectangle().width,bullet1.getRectangle().height);
	    	shapeRenderer.rect(bullet2.getRectangle().x , bullet2.getRectangle().y,bullet2.getRectangle().width,bullet2.getRectangle().height);
	    }
	    if(world.gameState == 2) {
	    	batch.draw(win1StateImg, 0, 0);
	    }
	    
	    if(world.gameState == 3) {
	    	batch.draw(win2StateImg, 0, 0);
	    }
	    batch.end();
	    shapeRenderer.end();
		
	}
}

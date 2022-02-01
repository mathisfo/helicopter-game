package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HeliGame;

import org.w3c.dom.css.Rect;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Helicopter  {
    private Texture texture;
    private Vector3 pos;
    private Vector3 vel;
    private TextureRegion textureRegion;
    private int x = Gdx.graphics.getWidth() / 2;
    private int y = Gdx.graphics.getHeight() / 2;



    private Rectangle rect;

    public Animator getAnimator() {
        return animator;
    }

    private Animator animator;
    Random rd = new Random();


    public Helicopter(int x, int y, int velX, int velY) {
        animator = new Animator();
        texture = animator.getCurrentTexture();
        textureRegion = new TextureRegion(texture);
        rect = new Rectangle(texture.getHeight(), texture.getWidth(), getX(), getY());
        x = this.x;
        y = this.y;
        pos = new Vector3(x, y , 0);
        vel = new Vector3(velX, velY, 0);


    }

    public void update() {


        if (x > Gdx.graphics.getWidth() - texture.getWidth()/8 || x < 0 + texture.getWidth()/9) {

            vel.x = -vel.x;

            //animator.getWalkAnimation().getKeyFrame(animator.getStateTime()).flip(true,false);


        }
        if (y > Gdx.graphics.getHeight() - texture.getHeight() / 2 || y < 0 + texture.getHeight() / 2) {
            vel.y = -vel.y;
        }


        rect.setPosition(getX(), getY());
        pos.add(x += vel.x, y += vel.y, 0);
    }

    public boolean collides(ArrayList<Rectangle> other) {
        for (Rectangle o : other) {
            if (o.overlaps(this.rect)) {
                return true;
            }
        }

        return false;
    }


    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public SpriteBatch getBatch() {
        return animator.getSpriteBatch();
    }
    public Rectangle getRect() {
        return rect;
    }
}
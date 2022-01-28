package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HeliGame;

import java.lang.reflect.Array;

public class Helicopter  {
    private Texture texture;
    private Vector3 pos;
    private Vector3 vel;
    private TextureRegion textureRegion;
    private int x = Gdx.graphics.getWidth() / 2;
    private int y = Gdx.graphics.getHeight() / 2;
    private Animator animator;


    public Helicopter(int x, int y) {
        animator = new Animator();

        texture = animator.getCurrentTexture();
        textureRegion = new TextureRegion(texture);
        pos = new Vector3(x, y, 0);
        vel = new Vector3(4, 4, 0);


        textureRegion.flip(true, false);

    }

    public void update() {

       if (x > Gdx.graphics.getWidth() - texture.getWidth() / 2 || x < texture.getWidth() / 2) {

           System.out.println(x > Gdx.graphics.getWidth() - texture.getWidth() / 2);


           vel.x = -vel.x;

            getTextureRegion().flip(true,false);


        }
        if (y > Gdx.graphics.getHeight() - texture.getHeight() / 2 || y < 0 + texture.getHeight() / 2) {

            vel.y = -vel.y;
        }


        //System.out.println("X: " + getX() + "Y: " + getY());F
        //System.out.println("velX: " + vel.x + "Y: " + vel.y);


        pos.add(x += vel.x, y += vel.y, 0);
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
}
package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;
import com.mygdx.game.HeliGame;

public class Helicopter  {
    private SpriteBatch batch;
    private Texture texture;
    private Vector3 pos;
    private Vector3 vel;
    private Sprite sprite;
    private TextureRegion textureRegion;

    private int x = Gdx.graphics.getWidth() / 2;
    private int y = Gdx.graphics.getHeight() / 2;


    public Helicopter(int x, int y) {
        texture = new Texture("attackhelicopter.PNG");
        textureRegion = new TextureRegion(texture);
        pos = new Vector3(x, y, 0);
        vel = new Vector3(4, 4, 0);
        sprite = new Sprite(texture);
        batch = new SpriteBatch();

        textureRegion.flip(true, false);

    }

    public void update() {
        if (x > Gdx.graphics.getWidth() - texture.getWidth() / 2 || x < texture.getWidth() / 2) {
            vel.x = -vel.x;

            getTextureRegion().flip(true,false);

            System.out.println(getTextureRegion().isFlipX());

        }
        if (y > Gdx.graphics.getHeight() - sprite.getTexture().getHeight() / 2 || y < 0 + sprite.getTexture().getHeight() / 2) {
            vel.y = -vel.y;
        }



        pos.add(x += vel.x, y += vel.y, 0);
    }

    public Sprite getSprite() {
        return sprite;
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
        return batch;
    }
}
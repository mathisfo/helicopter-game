package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Animator {
    private Texture images;
    private Animation<TextureRegion> animationCycle;
    private SpriteBatch spriteBatch;

    private float dtTime;

    public Animator() {

        images = new Texture(Gdx.files.internal("heliAnimaton.png"));

        TextureRegion[][] template = TextureRegion.split(images,
                images.getWidth() / 4,
                images.getHeight());

        TextureRegion[] frames = new TextureRegion[4];
        int index = 0;
        for (int i = 0; i < 1; i++) {
            for (int j = 0; j < 4; j++) {
                frames[index++] = template[i][j];
            }
        }

        animationCycle = new Animation<TextureRegion>(0.100f, frames);

        spriteBatch = new SpriteBatch();
        dtTime = 0f;
    }

    public Animation<TextureRegion> getAnimationCycle() {
        return animationCycle;
    }
    public Texture getCurrentTexture() {
        return animationCycle.getKeyFrame(dtTime).getTexture();
    }


    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public void incrementdtTime(float offset) {
        dtTime += offset;
    }

    public float getDtTime() {
        return dtTime;
    }




}

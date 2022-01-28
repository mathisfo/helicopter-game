package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Helicopter;

public class HeliGame extends ApplicationAdapter {

	Helicopter heli;
	private Animator animator;
	
	@Override
	public void create () {

		heli = new Helicopter(100,100);
		animator = new Animator();
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		heli.getBatch().begin();
		TextureRegion currentFrame = animator.getWalkAnimation().getKeyFrame(animator.getStateTime(), true);
		heli.getBatch().draw(currentFrame, heli.getX() - currentFrame.getTexture().getWidth()/2, heli.getY() - currentFrame.getTexture().getHeight()/2);
		heli.update();

		heli.getBatch().end();

		animator.incrementStateTime(Gdx.graphics.getDeltaTime()); // Accumulate elapsed animation time

	}
	
	@Override
	public void dispose () {
		heli.getBatch().dispose();
		heli.getTextureRegion().getTexture().dispose();
	}
}

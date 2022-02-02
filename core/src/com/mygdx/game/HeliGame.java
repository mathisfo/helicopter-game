package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.ArrayList;

public class HeliGame extends ApplicationAdapter {

	private ArrayList<Helicopter> helicopters;

	private Helicopter heli1;
	private Helicopter heli2;
	private Helicopter heli3;

	@Override
	public void create () {

		heli1 = new Helicopter(100,100, 5, 5);
		heli2 = new Helicopter(200,50, -4, -4);
		heli3 = new Helicopter(400,50, 2, 2);

		helicopters = new ArrayList<Helicopter>();

		//helicopters.add(heli1);
		helicopters.add(heli2);
		helicopters.add(heli3);
	}

	public Helicopter collides(Rectangle rect) {
		for (Helicopter h : helicopters) {
			if (h.getRect().overlaps(rect)) {
				return h;
			}
		}
		return null;
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);

		heli1.getBatch().begin();
		TextureRegion currentFrame = heli1.getAnimator().getAnimationCycle().getKeyFrame(heli1.getAnimator().getDtTime(), true);
		heli1.getBatch().draw(currentFrame, heli1.getX() - heli1.getTextureRegion().getTexture().getWidth()/9, heli1.getY() - heli1.getTextureRegion().getTexture().getHeight()/2);

		System.out.println("rect1: " + heli1.getRect().getX() + " " + heli1.getRect().getY());
		System.out.println("rect2: " + heli2.getRect().getX() + " " + heli2.getRect().getY());
		System.out.println(heli1.getRect().overlaps(heli2.getRect()));


		heli1.update(heli2.getRect());



		heli1.getBatch().end();
		heli1.getAnimator().incrementdtTime(Gdx.graphics.getDeltaTime()); // Accumulate elapsed animation time

		heli2.getBatch().begin();
		TextureRegion currentFrame2 = heli2.getAnimator().getAnimationCycle().getKeyFrame(heli2.getAnimator().getDtTime(), true);
		heli2.getBatch().draw(currentFrame2, heli2.getX() - heli2.getTextureRegion().getTexture().getWidth()/9, heli2.getY() - heli2.getTextureRegion().getTexture().getHeight()/2);
		heli2.update(heli1.getRect());
		heli2.getBatch().end();
		heli2.getAnimator().incrementdtTime(Gdx.graphics.getDeltaTime());

		heli3.getBatch().begin();
		TextureRegion currentFrame3 = heli3.getAnimator().getAnimationCycle().getKeyFrame(heli3.getAnimator().getDtTime(), true);
		heli3.getBatch().draw(currentFrame3, heli3.getX() - heli3.getTextureRegion().getTexture().getWidth()/9, heli3.getY() - heli3.getTextureRegion().getTexture().getHeight()/2);
		heli3.update(heli2.getRect());
		heli3.getBatch().end();
		heli3.getAnimator().incrementdtTime(Gdx.graphics.getDeltaTime());

	}
	
	@Override
	public void dispose () {
		heli1.getBatch().dispose();
		heli1.getTextureRegion().getTexture().dispose();
		heli2.getBatch().dispose();
		heli2.getTextureRegion().getTexture().dispose();
		heli3.getBatch().dispose();
		heli3.getTextureRegion().getTexture().dispose();
	}
}

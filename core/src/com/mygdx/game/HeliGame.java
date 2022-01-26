package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Helicopter;

public class HeliGame extends ApplicationAdapter {

	Helicopter heli;
	
	@Override
	public void create () {

		heli = new Helicopter(50,100);
	}


	@Override
	public void render () {
		ScreenUtils.clear(1, 0, 0, 1);
		heli.getBatch().begin();

		heli.getBatch().draw(heli.getTextureRegion(), heli.getX() - heli.getTextureRegion().getTexture().getWidth()/2, heli.getY() - heli.getTextureRegion().getTexture().getHeight()/2);
		heli.update();
		heli.getBatch().end();
	}
	
	@Override
	public void dispose () {
		heli.getBatch().dispose();
		heli.getSprite().getTexture().dispose();
	}
}

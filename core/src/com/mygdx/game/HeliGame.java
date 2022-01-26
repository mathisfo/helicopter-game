package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.ScreenUtils;


public class HeliGame extends ApplicationAdapter {

	private Helicopter heli;
	private Stage stage;
	private Touchpad touchpad;
	private Touchpad.TouchpadStyle touchpadStyle;
	private Skin touchpadSkin;
	private Drawable touchBackground;
	private Drawable touchKnob;
	private BitmapFont font;
	private SpriteBatch batch;
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		touchpadSkin = new Skin();
		touchpadSkin.add("bg", new Texture("bg.png"));
		touchpadSkin.add("input", new Texture("input.png"));

		touchpadStyle = new Touchpad.TouchpadStyle();
		touchBackground = touchpadSkin.getDrawable("bg");
		touchKnob = touchpadSkin.getDrawable("input");

		touchpadStyle.background = touchBackground;
		touchpadStyle.knob = touchKnob;

		touchpad = new Touchpad(10, touchpadStyle);
		touchpad.setBounds(0, 20, 150, 150);

		stage = new Stage();
		stage.addActor(touchpad);
		Gdx.input.setInputProcessor(stage);

		heli = new Helicopter(50,100, touchpad);
	}


	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		heli.getBatch().begin();
		heli.setVelocity(new Vector3(touchpad.getKnobPercentX()*4, touchpad.getKnobPercentY()*4, 0));
		heli.getBatch().draw(heli.getTextureRegion(), heli.getX() - heli.getTextureRegion().getTexture().getWidth()/2, heli.getY() - heli.getTextureRegion().getTexture().getHeight()/2);
		heli.update();
		heli.getBatch().end();
		String coor = "X: " + heli.getX() + "\n" + "Y: " + String.valueOf(heli.getY());
		batch.begin();
		font.draw(batch, coor, 15, 790);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
	}
	
	@Override
	public void dispose () {
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();
		heli.getBatch().dispose();
		heli.getSprite().getTexture().dispose();
	}
}

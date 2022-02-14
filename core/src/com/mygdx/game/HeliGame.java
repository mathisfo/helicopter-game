package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.state.GameState;
import com.mygdx.game.state.PauseState;
import com.mygdx.game.state.PlayState;

import java.util.ArrayList;

public class HeliGame extends ApplicationAdapter {

	static HeliGame heligame = new HeliGame();
	static Helicopter heli;
	private PlayState play;
	private PauseState pause;
	private static GameState<HeliGame> gameState;

	public static HeliGame getInstance() {
		return heligame;
	}

	public static GameState getState() {
		return gameState;
	}

	public static void setState(GameState state) {
		gameState = state;
	}


	@Override
	public void create() {

		play = new PlayState();
		pause = new PauseState();

		play.changeGameState(this);

		heli = Helicopter.getInstance();

	}


	@Override
	public void render() {


		if (getState() == play) {
			if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				ScreenUtils.clear(1, 0, 0, 1);
				pause.changeGameState(this);
				heli.getBatch().begin();
				heli.getBatch().draw(heli.getTextureRegion(), heli.getX() - heli.getTextureRegion().getTexture().getWidth() / 2, heli.getY() - heli.getTextureRegion().getTexture().getHeight() / 2);
				heli.setPauseVector();
				heli.getBatch().end();
			}

			else {

				ScreenUtils.clear(1, 0, 0, 1);
				heli.getBatch().begin();
				heli.getBatch().draw(heli.getTextureRegion(), heli.getX() - heli.getTextureRegion().getTexture().getWidth() / 2, heli.getY() - heli.getTextureRegion().getTexture().getHeight() / 2);
				heli.update();
				heli.getBatch().end();
			}

		}

		if (getState() == pause) {
			if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
				heli.setPlayVector();
				play.changeGameState(this);
			}

		}


	}

	@Override
	public void dispose() {
		heli.getBatch().dispose();
		heli.getSprite().getTexture().dispose();
	}


}
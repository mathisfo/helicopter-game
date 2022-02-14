package com.mygdx.game.state;

import com.mygdx.game.HeliGame;

public class PlayState implements GameState<HeliGame> {
    @Override
    public void changeGameState(HeliGame game) {
        //System.out.println("game is playing");
        game.setState(this);
    }
}

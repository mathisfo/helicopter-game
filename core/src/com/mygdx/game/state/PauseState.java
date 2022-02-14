
package com.mygdx.game.state;

import com.mygdx.game.HeliGame;

public class PauseState implements GameState<HeliGame> {

    @Override
    public void changeGameState(HeliGame game) {
        //System.out.println("game paused");
        game.setState(this);
    }
}
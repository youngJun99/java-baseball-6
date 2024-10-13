package baseball.domain.game;

import baseball.controller.InputManager;

import java.util.List;

public class WinValidator {

    public boolean winValidation(List<Integer> score){
        if (score.get(1)== InputManager.GAME_LENGTH)
            return true;
        else
            return false;
    }
}

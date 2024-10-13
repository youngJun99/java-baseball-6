package baseball.domain.game;

import baseball.controller.InputManager;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenarator {

    public List<Integer> generateRandNum() {

        List<Integer> number = new ArrayList<>();
        while (number.size() < InputManager.GAME_LENGTH) {
            int randNum = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randNum))
                number.add(randNum);
        }
        return number;
    }
}

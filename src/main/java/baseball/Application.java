package baseball;

import baseball.controller.GameController;
import baseball.controller.InputManager;
import baseball.domain.game.RandomNumberGenarator;
import baseball.domain.game.ScoreValidator;
import baseball.domain.game.WinValidator;
import baseball.view.ResultView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(
                new InputManager(),
                new RandomNumberGenarator(),
                new ScoreValidator(),
                new ResultView(),
                new WinValidator());

        gameController.play();

    }
}

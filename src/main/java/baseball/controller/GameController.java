package baseball.controller;

import baseball.domain.game.RandomNumberGenarator;
import baseball.domain.game.ScoreValidator;
import baseball.view.ResultView;

import java.util.List;

public class GameController {

    private InputManager inputManager;
    private RandomNumberGenarator randomNumberGenarator;
    private ScoreValidator scoreValidator;
    private ResultView resultView;
    private List<Integer> answerNumber;

    public GameController(InputManager inputManager, RandomNumberGenarator randomNumberGenarator, ScoreValidator scoreValidator, ResultView resultView) {
        this.inputManager = inputManager;
        this.randomNumberGenarator = randomNumberGenarator;
        this.scoreValidator = scoreValidator;
        this.resultView = resultView;
    }

    public void play(){
        inputManager.printGameStartMessage();
        boolean restart = true;
        while(restart){
            answerNumber = randomNumberGenarator.generateRandNum();
            List<Integer> playerGuess = inputManager.printAnswerRecieveMessage();
            List<Integer> score = scoreValidator.validateAnswer(answerNumber,playerGuess);
            resultView.printScore(score);
            restart = inputManager.printRestartMessage();
        }
    }

}

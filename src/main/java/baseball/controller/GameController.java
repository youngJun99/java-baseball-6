package baseball.controller;

import baseball.domain.game.RandomNumberGenarator;
import baseball.domain.game.ScoreValidator;
import baseball.domain.game.WinValidator;
import baseball.view.ResultView;

import java.util.List;

public class GameController {

    private InputManager inputManager;
    private RandomNumberGenarator randomNumberGenarator;
    private ScoreValidator scoreValidator;
    private ResultView resultView;
    private List<Integer> answerNumber;
    private WinValidator winValidator;

    public GameController(InputManager inputManager, RandomNumberGenarator randomNumberGenarator, ScoreValidator scoreValidator, ResultView resultView, WinValidator winValidator) {
        this.inputManager = inputManager;
        this.randomNumberGenarator = randomNumberGenarator;
        this.scoreValidator = scoreValidator;
        this.resultView = resultView;
        this.winValidator = winValidator;
    }

    public void play(){
        inputManager.printGameStartMessage();

        boolean token = true;
        while(token){

            boolean isWin = false;
            answerNumber = randomNumberGenarator.generateRandNum();

            while(!isWin){
                List<Integer> playerGuess = inputManager.printAnswerRecieveMessage();
                List<Integer> score = scoreValidator.validateAnswer(answerNumber,playerGuess);
                resultView.printScore(score);
                isWin = winValidator.winValidation(score);
            }

            token = inputManager.printRestartMessage();
        }
    }

}

package baseball.view;

import baseball.controller.InputManager;

import java.util.List;

public class ResultView {

    private static final String WIN_MESSAGE = "%d개의 숫자를 모두 맞히셨습니다! 게임종료";

    public void printScore(List<Integer> answerResult){
        int ball =answerResult.get(0);
        int strike = answerResult.get(1);

        if(ball == 0 && strike==0) {
            System.out.println("낫싱");
        }else if(strike == InputManager.GAME_LENGTH){
            System.out.println(strike+"스트라이크");
            System.out.println(String.format(WIN_MESSAGE,InputManager.GAME_LENGTH));
        }else if(ball==0){
            System.out.println(strike+"스트라이크");
        }else if(strike==0){
            System.out.println(ball+"볼");
        }else{
            System.out.println(ball+"볼 "+strike+"스트라이크");
        }
    }
}

package baseball.controller;


import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {

    private final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다";
    private final static String ANSWER_RECIEVE_MESSAGE = "숫자를 입력해 주세요: ";
    private final static String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static int GAME_LENGTH = 3;

    public void printGameStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public boolean printRestartMessage(){
        System.out.println(GAME_RESTART_MESSAGE);
        String restartNum = Console.readLine();
        validateRestartNum(restartNum);
        if(restartNum == "1") return true;
        else  return false;
    }

    public List<Integer> printStartMessage(){
        System.out.println(ANSWER_RECIEVE_MESSAGE);
        String answerRecieved = Console.readLine();
        return validateGameNum(answerRecieved);
    }

    private void validateRestartNum(String restartNum){
        if(restartNum.length() >1)
            throw new IllegalArgumentException("입력한 숫자의 길이가 너무 깁니다");
        if( restartNum.charAt(0)!=49 && restartNum.charAt(0)!=50 )
            throw new IllegalArgumentException("숫자가 1또는 2가 아닙니다");
    }

    private List<Integer> validateGameNum(String gameNum){
        if (gameNum.length() != GAME_LENGTH) {
            throw new IllegalArgumentException(String.format("%d 자리가 아닙니다.", GAME_LENGTH));
        }

        List<Integer> number = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (!(gameNum.charAt(i) >= 49 && gameNum.charAt(i) <= 57))
                throw new IllegalArgumentException("1 부터 9 사이 숫자가 아닙니다");
            if (!number.contains(Character.getNumericValue(gameNum.charAt(i))))
                number.add(Character.getNumericValue(gameNum.charAt(i)));
        }

        if (number.size() != GAME_LENGTH)
            throw new IllegalArgumentException("중복된 숫자가 들어가 있습니다");

        return number;
    }
}

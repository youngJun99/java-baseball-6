package baseball.domain.game;

import java.util.ArrayList;
import java.util.List;

public class ScoreValidator {

    public List<Integer> validateAnswer(List<Integer> answer, List<Integer> guess) {

        List<Integer> answerResult = List.of(0, 0);

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == guess.get(i)) answerResult.set(1, answerResult.get(1) + 1);
            for (int j = 0; j < answer.size(); j++) {
                if (answer.get(i) == guess.get(j) && i != j) answerResult.set(0, answerResult.get(0) + 1);
            }
        }
        return answerResult;
    }
}

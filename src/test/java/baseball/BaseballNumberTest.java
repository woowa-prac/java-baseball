package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.BaseballNumber.stringToIntegerList;

class BaseballNumberTest {

    @Test
    void 컴퓨터의_수가_425일_때_123을_제시한_경우_1strike() {
        List<Integer> opponentNumber = stringToIntegerList("425");
        List<Integer> playerNumber = stringToIntegerList("123");
        BaseballNumber opponent = new BaseballNumber(opponentNumber);
        BaseballNumber player = new BaseballNumber(playerNumber);

        Hint hint = player.compare(opponent);

        Assertions.assertEquals(hint.getStrike(), 1);
        Assertions.assertEquals(hint.getBall(), 0);
    }


    @Test
    void 잘못된입력_0이_들어간_입력을_제시한_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> playerNumber = stringToIntegerList("103");
        });
    }

    @Test
    void 잘못된입력_문자가_들어간_입력을_제시한_경우() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            List<Integer> playerNumber = stringToIntegerList("1a3");
        });
    }

    @Test
    void 컴퓨터의_수가_425일_때_425를_제시한_경우_isGameFinished가_True() {
        List<Integer> opponentNumber = stringToIntegerList("425");
        List<Integer> playerNumber = stringToIntegerList("425");
        BaseballNumber opponent = new BaseballNumber(opponentNumber);
        BaseballNumber player = new BaseballNumber(playerNumber);

        Hint hint = player.compare(opponent);

        Assertions.assertEquals(hint.getStrike(), 3);
        Assertions.assertEquals(hint.getBall(), 0);
        Assertions.assertTrue(hint.getIsGameFinished());
    }
}
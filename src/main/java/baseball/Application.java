package baseball;

import java.util.List;

import static baseball.BaseballNumber.stringToIntegerList;
import static baseball.InputView.readNumber;
import static baseball.OutputView.printHint;
import static baseball.OutputView.printStartGame;

public class Application {
    public static void main(String[] args) {
        Flag gameFlag = Flag.CONTINUE;
        while (gameFlag.equals(Flag.CONTINUE)) {
            printStartGame();
            List<Integer> opponentRandomNumber = RandomNumberGenerator.generateRandomNumbers();
            boolean isGameFinished = false;
            while (!isGameFinished) {
                List<Integer> playerNumber = stringToIntegerList(readNumber());
                BaseballNumber player = new BaseballNumber(playerNumber);
                BaseballNumber opponent = new BaseballNumber(opponentRandomNumber);
                Hint hint = player.compare(opponent);
                printHint(hint);
                isGameFinished = hint.getIsGameFinished(); // 게임종류 후 프린트하는걸 어디서 해야 할 지 고민
            }
            gameFlag = InputView.readWantGameContinue();
        }
    }
}

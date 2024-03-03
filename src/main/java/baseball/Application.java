package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static baseball.RandomNumberGenerator.generateRandomNumbers;

public class Application {
    static int digits = 3;

    public static void main(String[] args) throws IOException {
        Application app = new Application();
        app.startGame();
    }

    private void startGame() {
        int gameFlag = 1;
        while (gameFlag == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> randomNumbers = generateRandomNumbers(digits);
            GameLogic gameLogic = new GameLogic(digits);
            gameFlag = gameLogic.runGame(randomNumbers);
        }
    }
}

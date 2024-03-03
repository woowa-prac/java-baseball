package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.List;


public class GameLogic {
    private int ball;
    private int strike;
    private final int digits;

    public GameLogic(int digits) {
        this.digits = digits;
        this.strike = 0;
        this.ball = 0;
    }

    public int runGame(List<Integer> randomNumbers) {
        InputHandler inputHandler = new InputHandler();
        Outputhandler outputhandler = new Outputhandler();

        while (true) {
            initialize();

            List<Integer> inputList = inputHandler.getIntegerInputList(digits);

            calculateGameResult(randomNumbers, inputList);

            outputhandler.printResult(digits, strike, ball);

            if(this.strike == this.digits) {
                return inputHandler.getFlagInput();
            }
        }
    }

    private void calculateGameResult(List<Integer> randomNumbers, List<Integer> inputList) {
        for (int i = 0; i < digits; i++) {
            countStrikeNum(randomNumbers, inputList, i);
            for (int j = 0; j < digits; j++) {
                countBallNum(randomNumbers, inputList, i, j);
            }
        }
    }

    private void countBallNum(List<Integer> randomNumbers, List<Integer> inputList, int i, int j) {
        if(i != j && inputList.get(i).equals(randomNumbers.get(j))) {
            this.ball++;
        }
    }

    private void countStrikeNum(List<Integer> randomNumbers, List<Integer> inputList, int i) {
        if (inputList.get(i).equals(randomNumbers.get(i))) {
            this.strike++;
        }
    }

    private void initialize() {
        this.strike = 0;
        this.ball = 0;
    }
}

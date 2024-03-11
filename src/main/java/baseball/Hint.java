package baseball;

import static baseball.OutputView.printGameFinished;

public class Hint {
    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean getIsGameFinished() {
        if (strike == 3) {
            printGameFinished();
            return true;
        }
        return false;
    }
}

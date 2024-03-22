package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class BaseballNumber {

    private static final int BASEBALL_NUMBER_LENGTH = 3;

    private final String number;

    public BaseballNumber(String number) {
        validateInput(number);
        this.number = number;
    }

    private void validateInput(String str) {
        if (str.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                throw new IllegalArgumentException();
            }
            validateDuplicatedInput(str, ch);
        }
    }

    private void validateDuplicatedInput(String str, char ch) {
        if (str.chars().filter(c -> c == ch).count() != 1) {
            throw new IllegalArgumentException();
        }
    }

    public static BaseballNumber generateNumber() {
        String targetNum = "";
        while (targetNum.length() < BASEBALL_NUMBER_LENGTH) {
            String tmp = String.valueOf(Randoms.pickNumberInRange(0, 9));
            if (!targetNum.contains(tmp)) {
                targetNum = targetNum.concat(tmp);
            }
        }
        return new BaseballNumber(targetNum);
    }

    public int countStrike(BaseballNumber other) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (this.number.charAt(i) == other.number.charAt(i)) {
                cnt++;
            }
        }
        return cnt;
    }

    public int countBall(BaseballNumber other) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            if (other.number.contains(Character.toString(this.number.charAt(i)))) {
                cnt++;
            }
        }
        return cnt;
    }
}

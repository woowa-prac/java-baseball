package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballNumber {

    private final List<Integer> number;

    public BaseballNumber(List<Integer> number) {
        this.number = number;
    }

    public Hint compare(BaseballNumber opponent) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && this.number.get(i).equals(opponent.number.get(j))) {
                    ball++;
                }
            }
            if (this.number.get(i).equals(opponent.number.get(i))) {
                strike++;
            }
        }
        return new Hint(strike, ball);
    }

    private static void validate(List<Integer> number) {
        int size = number.size();
        if (size != 3) {
            throw new IllegalArgumentException();
        }
        for (Integer integer : number) {
            if (integer <= 0 || integer >= 10) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static List<Integer> stringToIntegerList(String number) {
        List<Integer> integerList = Arrays.stream(number.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());

        validate(integerList);
        return integerList;
    }
}

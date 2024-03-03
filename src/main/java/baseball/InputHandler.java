package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.ValidationUtils.validateFlagInput;
import static baseball.ValidationUtils.validateNumericInput;
import static java.util.Arrays.stream;

public class InputHandler {
    public List<Integer> getIntegerInputList(int digits) {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();

        validateNumericInput(input, digits);
        return stringToIntegerList(input);
    }

    public int getFlagInput() {
        String flagInput = Console.readLine();
        validateFlagInput(flagInput);
        return Integer.parseInt(flagInput);
    }



    private List<Integer> stringToIntegerList(String input) {
        return stream(input.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

}

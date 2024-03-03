package baseball;

public class ValidationUtils {
    public static void validateNumericInput(String input, int digits) {
        if (input.length() != digits) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c) || c == '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void validateFlagInput(String flagInput) {
        if (!flagInput.equals("1") && !flagInput.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}

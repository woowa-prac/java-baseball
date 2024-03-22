package baseball;

import static baseball.BaseballNumber.generateNumber;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        playGame();
    }

    public static void playGame() {
        do {
            playOneGame();
        } while (againGame());
    }

    private static void playOneGame() {
        BaseballNumber targetNum = generateNumber();
        while (true) {
            BaseballNumber inputNum = inputNumber();
            String output = outputResult(targetNum, inputNum);
            if (output.equals("3스트라이크")) {
                System.out.println(output);
                endGame();
                break;
            }
            System.out.println(output);
        }
    }

    private static BaseballNumber inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();
        return new BaseballNumber(inputNum);
    }

    private static String outputResult(BaseballNumber targetNum, BaseballNumber inputNum) {
        int strike = inputNum.countStrike(targetNum);
        int ball = inputNum.countBall(targetNum);
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0 && ball != 0) {
            return String.format("%d볼", ball);
        }
        if (strike != 0 && ball == 0) {
            return String.format("%d스트라이크", strike);
        }
        return String.format("%d볼 %d스트라이크", ball, strike);
    }

    private static void endGame() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static boolean againGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputString = Console.readLine();
        return inputString.equals("1");
    }
}

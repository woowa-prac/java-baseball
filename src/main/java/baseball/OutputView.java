package baseball;

public class OutputView {

    public static void printHint(Hint hint) {
        int strike = hint.getStrike();
        int ball = hint.getBall();

        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printGameFinished() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}

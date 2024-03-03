package baseball;

public class Outputhandler {
    public void printResult(int digits, int strike, int ball) {
        if (strike == digits) {
            System.out.println(strike + "스트라이크");
            System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            return;
        }

        if (ball > 0) System.out.print(ball + "볼 ");
        if (strike > 0) System.out.print(strike + "스트라이크 ");
        if (ball == 0 && strike == 0) System.out.print("낫싱");
        System.out.println();
    }
}

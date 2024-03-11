package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readNumber() { // 여기 inputView인데 print문 쓰는거 괜찮나?
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static Flag readWantGameContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int num = Integer.parseInt(Console.readLine());
        Flag.validate(num);

        if (num == 1) {
            return Flag.CONTINUE;
        }
        return Flag.EXIT;
    }
}

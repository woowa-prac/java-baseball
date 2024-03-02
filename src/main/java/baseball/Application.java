package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Application {
    static int digits = 3;
    static int strike = 0;
    static int ball = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gameFlag = 1;
        while (gameFlag == 1) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> randomNumbers = generateRandomNumbers(digits);
            gameFlag = runGame(br, randomNumbers);
        }

    }

    private static int runGame(BufferedReader br, List<Integer> randomNumbers) throws IOException {
        while (true) {
            initializeStrikeAndBall();

            System.out.print("숫자를 입력해주세요 : ");

            String input = br.readLine();
            validateInput(input);

            List<Integer> inputList = stringToIntegerList(input);

            countStrikeAndBallNum(randomNumbers, inputList);

            if (strike == digits) { // 모두 스트라이크
                System.out.println(strike + "스트라이크");
                System.out.println(strike + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                return Integer.parseInt(br.readLine());
            }

            if (ball > 0) System.out.print(ball + "볼 ");
            if (strike > 0) System.out.print(strike + "스트라이크 ");
            if (ball == 0 && strike == 0) System.out.print("낫싱");
            System.out.println();
        }

    }

    private static List<Integer> stringToIntegerList(String input) {
        List<Integer> inputList = stream(input.split(""))
                .map(Integer::parseInt).collect(Collectors.toList());
        return inputList;
    }

    private static void validateInput(String input) {
        if (input.length() != digits) {
            throw new IllegalArgumentException();
        }

        for (char c : input.toCharArray()) {
            if(!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void initializeStrikeAndBall() {
        strike = 0;
        ball = 0;
    }

    private static void countStrikeAndBallNum(List<Integer> randomNumbers, List<Integer> input) {
        for (int i = 0; i < digits; i++) {
            countStrikeNum(randomNumbers, input, i);
            for (int j = 0; j < digits; j++) {
                countBallNum(randomNumbers, input, i, j);
            }
        }
    }

    private static void countBallNum(List<Integer> randomNumbers, List<Integer> input, int i, int j) {
        if(i != j && input.get(i).equals(randomNumbers.get(j))) {
            ball++;
        }
    }

    private static void countStrikeNum(List<Integer> randomNumbers, List<Integer> input, int i) {
        if (input.get(i).equals(randomNumbers.get(i))) {
            strike++;
        }
    }

    private static List<Integer> generateRandomNumbers(int length) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}

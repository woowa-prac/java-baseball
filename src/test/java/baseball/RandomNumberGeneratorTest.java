package baseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.RandomNumberGenerator.generateRandomNumbers;

class RandomNumberGeneratorTest {

    @Test
    void 랜덤값_생성시_3자리이며_각_자리에_1에서9까지_의_숫자만_생성() {
        List<Integer> integers = generateRandomNumbers();
        Assertions.assertEquals(integers.size(), 3);

        for (int i = 0; i < 3; i++) {
            if (integers.get(i) >= 10 || integers.get(i) <= 0) {
                Assertions.fail();
            }
        }
    }
}
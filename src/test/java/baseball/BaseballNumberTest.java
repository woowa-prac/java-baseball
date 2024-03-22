package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballNumberTest {

    @Test
    void 생성_시_3자리_숫자가_아니면_예외() {
        // when & then
        assertThatThrownBy(() ->
                new BaseballNumber("1234")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자에_중복이_있으면_예외() {
        // when & then
        assertThatThrownBy(() ->
                new BaseballNumber("112")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{1}과 {2}를 비교하면 {3} 스트라이크이다")
    @CsvSource(value = {
            "123,143,2",
            "124,143,1",
    })
    void 같은_위치에_같은_수가_있으면_스트라이크(String num1, String num2, int expected) {
        // given
        BaseballNumber baseballNumber = new BaseballNumber(num1);
        BaseballNumber other = new BaseballNumber(num2);

        // when
        int actual = baseballNumber.countStrike(other);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 다른_위치에_같은_수가_있으면_볼() {
        // given
        BaseballNumber baseballNumber = new BaseballNumber("123");
        BaseballNumber other = new BaseballNumber("341");

        // when
        int result = baseballNumber.countBall(other);

        // then
        assertThat(result).isEqualTo(2);
    }
}
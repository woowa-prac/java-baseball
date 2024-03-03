package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임종료_후_재시작시_잘못된_입력() {
        assertRandomNumberInRangeTest(
            () -> {
                assertThrows(IllegalArgumentException.class, () -> {
                    run("246", "135", "a", "597", "589", "2");

                });
                assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
            },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임중_0_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        run("246", "013", "135");

                    });
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임중_잘못된_입력길이_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        run("246", "13", "135");
                    });
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 게임중_문자_입력() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThrows(IllegalArgumentException.class, () -> {
                        run("246", "1a3", "135");

                    });
                    assertThat(output()).contains("낫싱");
                },
                1, 3, 5, 5, 8, 9
        );
    }



    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

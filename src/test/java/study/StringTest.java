package study;

import baseball.InputHandler;
import baseball.ValidationUtils;
import org.junit.jupiter.api.Test;

import java.io.Console;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StringTest {

    @Test
    void split_메서드로_주어진_값을_구분() {
        String input = "1,2";
        String[] result = input.split(",");

        assertThat(result).contains("2", "1");
        assertThat(result).containsExactly("1", "2");
    }

    @Test
    void split_메서드_사용시_구분자가_포함되지_않은_경우_값을_그대로_반환() {
        String input = "1";
        String[] result = input.split(",");

        assertThat(result).contains("1");
    }

    @Test
    void substring_메서드로_특정_구간_값을_반환() {
        String input = "(1,2)";
        String result = input.substring(1, 4);

        assertThat(result).isEqualTo("1,2");
    }

    @Test
    void charAt_메서드로_특정_위치의_문자_찾기() {
        String input = "abc";
        char charAtElement = input.charAt(0);
        assertThat(charAtElement).isEqualTo('a');
    }

    @Test
    void charAt_메서드_사용시_문자열의_길이보다_큰_숫자_위치의_문자를_찾을_때_예외_발생() {
        String input = "abc";

        assertThatThrownBy(() -> input.charAt(5))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

    @Test
    void Input이_잘_들어왔는지_확인() {
        Console consoleMock = mock(Console.class);

        when(consoleMock.readLine()).thenReturn("123");

        InputHandler inputHandler = new InputHandler();

        List<Integer> integerInputList = inputHandler.getIntegerInputList(3);
        assertThat(integerInputList).containsExactly(1, 2, 3);

    }

    @Test
    void 잘못된_입력이_들어오면_예외() {
        Console consoleMock = mock(Console.class);
        InputHandler inputHandler = new InputHandler();

        when(consoleMock.readLine()).thenReturn("1b3");
        assertThatThrownBy(() -> ValidationUtils.validateNumericInput("012", 3))
                .isInstanceOf(IllegalArgumentException.class);

//        when(consoleMock.readLine()).thenReturn("130");
//        assertThatThrownBy(() -> inputHandler.getIntegerInputList(3))
//                .isInstanceOf(IllegalArgumentException.class);


    }

    @Test
    void 플래그에_잘못된_입력이_들어오면_예외() {
        Console consoleMock = mock(Console.class);

        when(consoleMock.readLine()).thenReturn("1b3");
        assertThatThrownBy(() -> ValidationUtils.validateFlagInput("3"))
                .isInstanceOf(IllegalArgumentException.class);

//        when(consoleMock.readLine()).thenReturn("3");
//        assertThatThrownBy(() -> inputHandler.getFlagInput())
//                .isInstanceOf(IllegalArgumentException.class);
    }






}

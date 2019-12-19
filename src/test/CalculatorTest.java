import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void 단일_숫자_입력_테스트() {
        assertEquals(6, new Calculator().run("6"));
    }

    @ParameterizedTest
    @MethodSource("더하기_테스트_데이터")
    void 더하기_테스트(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> 더하기_테스트_데이터() {
        return Stream.of(
                Arguments.of(3d + 5, "3 + 5"),
                Arguments.of(4d + 7 + 10, "4 + 7 + 10")
        );
    }

    @ParameterizedTest
    @MethodSource("빼기_테스트_데이터")
    void 빼기_테스트(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> 빼기_테스트_데이터() {
        return Stream.of(
                Arguments.of(8d - 5, "8 - 5"),
                Arguments.of(21d - 7 - 9, "21 - 7 - 9")
        );
    }

    @ParameterizedTest
    @MethodSource("곱하기_테스트_데이터")
    void 곱하기_테스트(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> 곱하기_테스트_데이터() {
        return Stream.of(
                Arguments.of(7d * 5, "7 * 5"),
                Arguments.of(4d * 7 * 8, "4 * 7 * 8")
        );
    }

    @ParameterizedTest
    @MethodSource("나누기_테스트_데이터")
    void 나누기_테스트(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> 나누기_테스트_데이터() {
        return Stream.of(
                Arguments.of(21d / 3, "21 / 3"),
                Arguments.of(385d / 11 / 7, "385 / 11 / 7")
        );
    }

    @ParameterizedTest
    @MethodSource("복합_연산_테스트_데이터")
    void 복합_연산_테스트(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> 복합_연산_테스트_데이터() {
        return Stream.of(
                Arguments.of((21d / 3 + 7 - 5) * 6, "21 / 3 + 7 - 5 * 6"),
                Arguments.of(((285d + 100) / 7 - 80) * 3, "285 + 100 / 7 - 80 * 3"),
                Arguments.of(((22d / 2 + 4) / 5 * 7 - 6) / 3, "22 / 2 + 4 / 5 * 7 - 6 / 3")
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void 공백_입력에_대한_에러_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator().run(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"d + 3", "4 & 3", "5 /' 5"})
    void 오타_입력에_대한_에러_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator().run(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + * 7", "/ 5 + 6", "4 -", "*", "9 3"})
    void 연산식_오류에_대한_에러_처리_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator().run(input));
    }
}
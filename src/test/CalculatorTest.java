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
    void ����_����_�Է�_�׽�Ʈ() {
        assertEquals(6, new Calculator().run("6"));
    }

    @ParameterizedTest
    @MethodSource("���ϱ�_�׽�Ʈ_������")
    void ���ϱ�_�׽�Ʈ(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> ���ϱ�_�׽�Ʈ_������() {
        return Stream.of(
                Arguments.of(3d + 5, "3 + 5"),
                Arguments.of(4d + 7 + 10, "4 + 7 + 10")
        );
    }

    @ParameterizedTest
    @MethodSource("����_�׽�Ʈ_������")
    void ����_�׽�Ʈ(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> ����_�׽�Ʈ_������() {
        return Stream.of(
                Arguments.of(8d - 5, "8 - 5"),
                Arguments.of(21d - 7 - 9, "21 - 7 - 9")
        );
    }

    @ParameterizedTest
    @MethodSource("���ϱ�_�׽�Ʈ_������")
    void ���ϱ�_�׽�Ʈ(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> ���ϱ�_�׽�Ʈ_������() {
        return Stream.of(
                Arguments.of(7d * 5, "7 * 5"),
                Arguments.of(4d * 7 * 8, "4 * 7 * 8")
        );
    }

    @ParameterizedTest
    @MethodSource("������_�׽�Ʈ_������")
    void ������_�׽�Ʈ(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> ������_�׽�Ʈ_������() {
        return Stream.of(
                Arguments.of(21d / 3, "21 / 3"),
                Arguments.of(385d / 11 / 7, "385 / 11 / 7")
        );
    }

    @ParameterizedTest
    @MethodSource("����_����_�׽�Ʈ_������")
    void ����_����_�׽�Ʈ(Double expected, String input) {
        assertEquals(expected, new Calculator().run(input));
    }

    private static Stream<Arguments> ����_����_�׽�Ʈ_������() {
        return Stream.of(
                Arguments.of((21d / 3 + 7 - 5) * 6, "21 / 3 + 7 - 5 * 6"),
                Arguments.of(((285d + 100) / 7 - 80) * 3, "285 + 100 / 7 - 80 * 3"),
                Arguments.of(((22d / 2 + 4) / 5 * 7 - 6) / 3, "22 / 2 + 4 / 5 * 7 - 6 / 3")
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "\t", "\n"})
    void ����_�Է¿�_����_����_ó��_�׽�Ʈ(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator().run(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"d + 3", "4 & 3", "5 /' 5"})
    void ��Ÿ_�Է¿�_����_����_ó��_�׽�Ʈ(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator().run(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 + * 7", "/ 5 + 6", "4 -", "*", "9 3"})
    void �����_������_����_����_ó��_�׽�Ʈ(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator().run(input));
    }
}
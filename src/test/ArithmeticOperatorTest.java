import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperatorTest {

    @ParameterizedTest
    @MethodSource("operate_������")
    void operate(double expected, double augend, String arithmeticOperator, double addend) {
        assertEquals(expected, ArithmeticOperator.operate(augend, arithmeticOperator, addend));
    }

    private static Stream<Arguments> operate_������() {
        return Stream.of(
                Arguments.of(11, 8, "+", 3),
                Arguments.of(16, 27, "-", 11),
                Arguments.of(54, 9, "*", 6),
                Arguments.of(7, 84, "/", 12)
        );
    }

    @Test
    void isCorrespondingOperator() {
        assertTrue(ArithmeticOperator.PLUS.isCorrespondingOperator("+"));
        assertFalse(ArithmeticOperator.MINUS.isCorrespondingOperator("+"));
        assertFalse(ArithmeticOperator.MULTIPLY.isCorrespondingOperator("+"));
        assertFalse(ArithmeticOperator.DIVIDE.isCorrespondingOperator("+"));

        assertFalse(ArithmeticOperator.PLUS.isCorrespondingOperator("-"));
        assertTrue(ArithmeticOperator.MINUS.isCorrespondingOperator("-"));
        assertFalse(ArithmeticOperator.MULTIPLY.isCorrespondingOperator("-"));
        assertFalse(ArithmeticOperator.DIVIDE.isCorrespondingOperator("-"));

        assertFalse(ArithmeticOperator.PLUS.isCorrespondingOperator("*"));
        assertFalse(ArithmeticOperator.MINUS.isCorrespondingOperator("*"));
        assertTrue(ArithmeticOperator.MULTIPLY.isCorrespondingOperator("*"));
        assertFalse(ArithmeticOperator.DIVIDE.isCorrespondingOperator("*"));

        assertFalse(ArithmeticOperator.PLUS.isCorrespondingOperator("/"));
        assertFalse(ArithmeticOperator.MINUS.isCorrespondingOperator("/"));
        assertFalse(ArithmeticOperator.MULTIPLY.isCorrespondingOperator("/"));
        assertTrue(ArithmeticOperator.DIVIDE.isCorrespondingOperator("/"));
    }

    @ParameterizedTest
    @MethodSource("getOperationResult_������")
    void getOperationResult(double augend, double addend) {
        assertEquals(augend + addend, ArithmeticOperator.PLUS.getOperationResult(augend, addend));
        assertEquals(augend - addend, ArithmeticOperator.MINUS.getOperationResult(augend, addend));
        assertEquals(augend * addend, ArithmeticOperator.MULTIPLY.getOperationResult(augend, addend));
        assertEquals(augend / addend, ArithmeticOperator.DIVIDE.getOperationResult(augend, addend));
    }

    private static Stream<Arguments> getOperationResult_������() {
        return Stream.of(
                Arguments.of(28, 7),
                Arguments.of(165, 11),
                Arguments.of(14, 1)
        );
    }
}
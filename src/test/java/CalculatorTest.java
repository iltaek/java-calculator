import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {
    @Test
    void testSample() {
        assertEquals(new Calculator("2 + 3 * 4 / 2").calculate(), 10.0);
    }

    @Test
    void DivideByNull() {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    new Calculator("5 / 0").calculate();
                });
    }

    @Test
    void IllegalExpr() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("1 +").calculate();
                });
    }

    @Test
    void IllegalExpr2() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("1 2 3").calculate();
                });
    }

    @Test
    void IllegalExpr3() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Calculator("+ / -").calculate();
                });
    }
}
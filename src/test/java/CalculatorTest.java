import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void testSample() {
        assertEquals(Calculator.calculate("2 + 3 * 4 / 2"), 10.0);
    }
}
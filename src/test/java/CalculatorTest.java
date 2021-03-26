import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("계산기1 정상 입력 테스트")
    void calculate1_Normal_Test() {
        assertThat(calculator.calculate("1 + 2")).isEqualTo(3.0);
        assertThat(calculator.calculate("1")).isEqualTo(1.0);
        assertThat(calculator.calculate("1 - 2 + 3 * 4 / 5")).isEqualTo(1.6);
    }

    @Test
    @DisplayName("계산기1 비정상 입력 테스트 (숫자 연속 입력)")
    void calculate1_Abnormal_Test1() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1 + 1 1 + 1");
        });
    }

    @Test
    @DisplayName("계산기1 비정상 입력 테스트 (연산자 연속 입력)")
    void calculate1_Abnormal_Test2() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1 + - 1 + 1");
        });
    }

    @Test
    @DisplayName("계산기1 비정상 입력 테스트 (연산자로 시작)")
    void calculate1_Abnormal_Test3() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("+ 1");
        });
    }

    @Test
    @DisplayName("계산기1 비정상 입력 테스트 (연산자로 종료)")
    void calculate1_Abnormal_Test4() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculate("1 + 1 +");
        });
    }
}
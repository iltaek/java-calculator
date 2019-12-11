import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  @DisplayName("계산기1 기능 테스트")
  void calculate1Test() {
    Calculator calculator = new Calculator();
    assertThat(calculator.calculate("1 + 2")).isEqualTo(3.0);
    assertThat(calculator.calculate("1")).isEqualTo(1.0);
    assertThat(calculator.calculate("1 - 2 + 3 * 4 / 5")).isEqualTo(1.6);
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate("1 + 1 1 + 1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate("1 + - 1 + 1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate("+ 1 1 + 1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate("1 + 1 +");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      calculator.calculate("+");
    });
  }

  @Test
  @DisplayName("계산기2 기능 테스트")
  void calculate2Test() {
    assertThat(Calculator2.calculate("1 + 2")).isEqualTo(3.0);
    assertThat(Calculator2.calculate("1")).isEqualTo(1.0);
    assertThat(Calculator2.calculate("1 - 2 + 3 * 4 / 5")).isEqualTo(1.6);
    assertThrows(IllegalArgumentException.class, () -> {
      Calculator2.calculate("1 + 1 1 + 1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculator2.calculate("1 + - 1 + 1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculator2.calculate("+ 1 1 + 1");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculator2.calculate("1 + 1 +");
    });
    assertThrows(IllegalArgumentException.class, () -> {
      Calculator2.calculate("+");
    });
  }
}

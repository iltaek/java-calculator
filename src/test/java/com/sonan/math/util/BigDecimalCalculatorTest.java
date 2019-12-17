package com.sonan.math.util;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

/**
 * Github: http://github.com/sonanDev
 * Created by: jindam91@gmail.com
 * @created: 2019-12-13
 * @since: 1.8
 */
class BigDecimalCalculatorTest {

  @DisplayName("실수 계산기 생성 테스트.")
  @Test
  void constructorCalculator() {
    Calculator calculator = new BigDecimalCalculator();
  }

  @DisplayName("실수 계산기의 더하기 연산. 존재할 수 있는 모든 실수를 커버한다. TODO: 아직 not working.")
  @ParameterizedTest
  @ValueSource(strings = {"1 + 2", " 1 + 2  ", "5 + 1 + 9", "9999999999999999 + 9999999999999999", "1234.1234 + 1234.1234"})
  void add(String expression, String expect) {
    Calculator<BigDecimal> calculator = new BigDecimalCalculator();
    assertEquals(calculator.calc(expression).orElse(BigDecimal.ZERO), expect);
  }

  @Test
  void subtract() {
  }

  @Test
  void multiply() {
  }

  @Test
  void divide() {
  }
}
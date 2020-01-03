package com.sonan.math.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
  @CsvSource({"1 + 2,3", " 1 + 2  ,3", "5 + 1 + 9,15", "9999999999999999 + 9999999999999999,19999999999999998", "1234.1234 + 1234.1234,2468.2468"})
  void add(String expression, String expect) {
    // TODO : add에 대한 symbol (+)을 이용해 유니크한 OperationIdentifier.ADD를 얻어낸뒤, ADD 연산을 수행시킨 결과물을 검증한다.

//    Calculator<BigDecimal> calculator = new BigDecimalCalculator();
//    assertEquals(calculator.calc(expression).orElse(BigDecimal.ZERO), expect);
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
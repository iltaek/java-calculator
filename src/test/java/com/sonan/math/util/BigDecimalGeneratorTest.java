package com.sonan.math.util;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-17
 * @since: 1.8
 */
class BigDecimalGeneratorTest {

  @DisplayName("생성자")
  @Test
  void constructor() {
    NumberGenerator builder = new BigDecimalGenerator();
  }

  @DisplayName("더하기 연산")
  @ParameterizedTest
  @CsvSource({"1,2,3", "0,0,0", "5,1000000000000000000000,1000000000000000000005", "1000000000000000000000,0,1000000000000000000000", "9999999999999999,9999999999999999,19999999999999998", "1234.1234,1234.1234,2468.2468"})
  void add(String base, String target, String result) {
    NumberGenerator<BigDecimal> builder = new BigDecimalGenerator(base);
    builder.add(new BigDecimal(target));
    assertEquals(builder.getResult(), new BigDecimal(result));
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
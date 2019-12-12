package com.sonan.util;

import static org.junit.jupiter.api.Assertions.*;

import java.text.NumberFormat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

/**
 * Github: http://github.com/sonanDev Created by: jindam91@gmail.com
 *
 * @created: 2019-12-13
 * @since: 1.8
 */
class NumberCalculatorTest {
  private static final Logger logger = LoggerFactory.getLogger(NumberCalculatorTest.class);

  @DisplayName("Should Be number. cover with any real number.")
  @ParameterizedTest(name = "{index} => num={0}")
  @CsvFileSource(resources = "/csv/NumberCalculatorTestInitNumber.csv")
  void constructorNumber(String num) {
    try {
      Calculator calculator = new NumberCalculator(NumberFormat.getInstance().parse(num));
    } catch (Exception e) {
      logger.warn(e, () -> "csv file is not valid.");
    }
  }

  @Test
  void add() {
  }

  @Test
  void divide() {
  }

  @Test
  void multiply() {
  }

  @Test
  void substract() {
  }
}
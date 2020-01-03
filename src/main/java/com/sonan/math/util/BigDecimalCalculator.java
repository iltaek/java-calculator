package com.sonan.math.util;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * 실수 계산기.
 * BigDecimal로 구현되어있다.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-16
 * @since: 1.8
 */
public class BigDecimalCalculator implements Calculator<BigDecimal> {



  /**
   * expression 대로 연산을 진행하여 BigDecimal 반환.
   *
   * @param expr
   * @return
   */
  @Override
  public Optional<BigDecimal> calc(String expr) {
    return Optional.of(BigDecimal.ZERO);
  }
}

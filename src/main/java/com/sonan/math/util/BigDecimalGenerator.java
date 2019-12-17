package com.sonan.math.util;

import java.math.BigDecimal;

/**
 * 실수 Generator.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-17
 * @since: 1.8
 */
public class BigDecimalGenerator implements NumberGenerator<BigDecimal> {

  private BigDecimal result = null;

  public BigDecimalGenerator() {
    this.result = BigDecimal.ZERO;
  }

  public BigDecimalGenerator(BigDecimal base) {
    if (base != null) {
      this.result = new BigDecimal(base.toString());
    }
  }

  public BigDecimalGenerator(String base) {
    try {
      this.result = new BigDecimal(base);
    } catch (Exception e) {
      // do nothing.
    }
  }

  @Override
  public NumberGenerator add(BigDecimal number) {
    if (this.result != null) {
      this.result = this.result.add(number);
    }
    return this;
  }

  @Override
  public NumberGenerator subtract(BigDecimal number) {
    return null;
  }

  @Override
  public NumberGenerator multiply(BigDecimal number) {
    return null;
  }

  @Override
  public NumberGenerator divide(BigDecimal number) {
    return null;
  }

  @Override
  public BigDecimal getResult() {
    return this.result;
  }
}

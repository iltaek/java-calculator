package com.sonan.util;

import com.sonan.message.Constant;
import java.util.Optional;

/**
 * 계산기의 구현체.
 *
 * Github: http://github.com/sonanDev
 * Created by: jindam91@gmail.com
 * @created: 2019-12-13
 * @since: 1.8
 */
public class NumberCalculator implements Calculator {

  private Number result;

  public NumberCalculator(Number num) {
    if (num == null) {
      throw new NullNotCalculateException(Constant.nullNotAvailable);
    }
    this.result = num;
  }

  @Override
  public Calculator add(Number num) {
    return null;
  }

  @Override
  public Calculator divide(Number num) {
    return null;
  }

  @Override
  public Calculator multiply(Number num) {
    return null;
  }

  @Override
  public Calculator substract(Number num) {
    return null;
  }

  @Override
  public Number getResult() {
    return null;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Calculator) {
      return this.getResult().equals(((Calculator) obj).getResult());
    }
    return false;
  }

  @Override
  public String toString() {
    return this.getResult().toString();
  }
}

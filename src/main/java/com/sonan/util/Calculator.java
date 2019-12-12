package com.sonan.util;

import java.util.Optional;
/**
 * 계산기에 대한 interface.
 *
 * Github : http://github.com/sonanDev
 * Created by jindam91@gmail.com
 * @created:
 * @since: 1.8
 */
public interface Calculator {
  Calculator add(Number num);
  Calculator divide(Number num);
  Calculator multiply(Number num);
  Calculator substract(Number num);
  Number getResult();
}

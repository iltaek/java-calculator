package com.sonan.math.util;

/**
 * NumberGenerator. 숫자가 생성된다. 연산 이후에 결과는 getResult를 통해 얻는다.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-17
 * @since: 1.8
 */
public interface NumberGenerator<T> {
  NumberGenerator add(T number);
  NumberGenerator subtract(T number);
  NumberGenerator multiply(T number);
  NumberGenerator divide(T number);
  T getResult();
}

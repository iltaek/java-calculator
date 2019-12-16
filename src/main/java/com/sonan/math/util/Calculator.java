package com.sonan.math.util;

import java.util.Optional;

/**
 * 계산기에 대한 interface.
 * calc는 계산식 전체를 String으로 받아, calc의 반환값은 Optional 로 Wrapping 된 값이다.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-17
 * @since: 1.8
 */

public interface Calculator<R> {

  /**
   * expression 대로 연산을 진행한다.
   *
   * @param expression 계산 연산 식 전체.
   * @return 연산된 값.
   */
    Optional<R> calc(String expression);
}

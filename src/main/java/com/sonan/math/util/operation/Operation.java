package com.sonan.math.util.operation;

import java.util.List;
import java.util.Optional;

/**
 * 계산기에서 연산할 때 쓰는 연산자.
 * ex: +, -, *, /
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-17
 * @since: 1.8
 */
@FunctionalInterface
public interface Operation<T> {

  /**
   * N가지 숫자를 이용해 연산을 진행하여 반환한다.
   *
   * @param numbers 연산을 진행할 Number들
   * @return 연산된 결과값
   */
  Optional<T> calc(List<T> numbers);
}

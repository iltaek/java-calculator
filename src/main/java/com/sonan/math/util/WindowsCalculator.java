package com.sonan.math.util;

import java.util.Optional;

/**
 * windows 계산기.
 *
 * history로 연산 내용이 관리됨.
 * 최근의 연산을 을 최근 결과값에 재연산 가능.
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-17
 * @since: 1.8
 */
public interface WindowsCalculator<R> extends Calculator<R> {

  /**
   * expression 대로 연산을 진행하며, 연산들은 분해되어 history로 관리됨.
   *
   * @param expression 계산 연산 식 전체.
   * @return 연산된 값.
   */
  @Override
  Optional<R> calc(String expression);


  /**
   * history에 관리되는 가장 최근에 사용된 연산 opertion을 가장 최근의 결과값에 재 연산.
   * @return 연산된 값.
   */
  Optional<R> calc();
}

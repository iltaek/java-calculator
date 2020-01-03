package com.sonan.math.util.operation;

import java.util.Optional;

/**
 * operation symbol <-> operation identifier
 *
 * 내부 field로 알아서 symbol과 identifier를 자료구조로 정리하고 있는다.
 *
 * 규칙 :
 * 1. 하나의 기호(symbol)은 하나의 식별자(identifier)와 매칭된다.
 * 2. 하나의 식별자(identifier)는 여러개의 기호(symbol)와 매칭될 수 있다.
 * 3. 식별자로 기호를 얻으려하면, 식별자에 대해 가장 처음에 등록되었던 기호가 반환될 것이다.
 *
 * ex: + -> OperationIdentifier.ADD -> +
 * ex: plus -> OperationIdentifier.ADD -> +
 * ex: * -> OperationIdentifier.MULTIPLY -> *
 * ex: x -> OperationIdentifier.MULTIPLY -> x
 *
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-18
 * @since: 1.8
 */
public interface OperationMatcher {

  /**
   * 연산자의 기호로 연산자의 식별자를 찾아 반환한다.
   * identifier에 해당하는 기호가 많을 경우, 가장 처음 등록된 기호가 반환된다.
   *
   * @param symbol 연산자의 기호
   * @return 연산자의 식별자
   */
  public Optional<OperationIdentifier> getIdentifier(String symbol);


  /**
   * 연산자의 식별자로 연산자의 기호를 찾아 반환한다.
   *
   * @param id 연산자의 식별자
   * @return 식별자에 가장 처음에 등록된 연산자의 기호
   */
  public Optional<String> getSymbol(OperationIdentifier id);
}

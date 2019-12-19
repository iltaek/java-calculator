package com.sonan.math.util.operation;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * BigDecimal 계산기에서, 연산할 때 쓰는 연산자들을 저장하는 Map class.
 * first-class-collection.
 * ex: +, -, *, /
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-18
 * @since: 1.8
 */
public class BigDecimalOperations implements Operations<BigDecimal> {

  private Map<OperationIdentifier, Operation<BigDecimal>> route;

  public BigDecimalOperations() {
    this.route = new HashMap<>();

    route.put(OperationIdentifier.ADD, ((numbers) -> {
      try {
        return Optional.ofNullable(numbers.get(0).add(numbers.get(1)));
      } catch (Exception e) {
        return Optional.empty();
      }
    }));

    route.put(OperationIdentifier.SUBTRACT, ((numbers) -> {
      try {
        return Optional.ofNullable(numbers.get(0).subtract(numbers.get(1)));
      } catch (Exception e) {
        return Optional.empty();
      }
    }));

    route.put(OperationIdentifier.MULTIPLY, ((numbers) -> {
      try {
        return Optional.ofNullable(numbers.get(0).multiply(numbers.get(1)));
      } catch (Exception e) {
        return Optional.empty();
      }
    }));

    route.put(OperationIdentifier.DIVIDE, ((numbers) -> {
      try {
        return Optional.ofNullable(numbers.get(0).divide(numbers.get(1)));
      } catch (Exception e) {
        return Optional.empty();
      }
    }));
  }

  public BigDecimalOperations(Map<OperationIdentifier, Operation<BigDecimal>> route) {
    this.route = route;
  }

  @Override
  public Optional<Operation<BigDecimal>> get(OperationIdentifier key) {
    try {
      return Optional.ofNullable(route.get(key));
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}

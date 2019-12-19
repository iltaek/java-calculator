package com.sonan.math.util.operation;

import java.util.Optional;

/**
 * 계산기에서 연산할 때 쓰는 연산자의 Map first-class-collection interface
 * ex: +, -, *, /
 *
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-18
 * @since: 1.8
 */
public interface Operations<T> {
  Optional<Operation<T>> get(OperationIdentifier key);
}

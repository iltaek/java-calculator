package com.sonan.math.util.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * operation symbol <-> operation identifier
 *
 * 많은 기호(symbol)와 매치되는 하나의 식별자(identifier)가 있으면, 해당 식별자를 통해서는 리스트의 첫번째
 * 기호를 반환받을 것이다.
 *
 * 하나의 기호(symbol)은 하나의 identifier과 매칭된다.
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
public class OperationMatcherImpl implements OperationMatcher{

  private final Map<String, OperationIdentifier> symbolToId = new HashMap<>();
  private final Map<OperationIdentifier, List<String>> idToSymbol = new HashMap<>();

  private static OperationMatcherImpl instance = null;

  public static OperationMatcherImpl getInstance() {
    if (instance == null) {
      instance = new OperationMatcherImpl();
    }
    return instance;
  }

  private OperationMatcherImpl() {
    // TODO: 다국어나 개개인별로 기호를 다르게 줄 수 있다. 이를 지원하기위해 별도 파일로 다국어를 뺄 수 있게 한다. Test에서도 파일을 읽는 식으로 진행하면 Test도 working하게 변경가능하다.
    symbolToId.put("+", OperationIdentifier.ADD);
    symbolToId.put("더하기", OperationIdentifier.ADD);
    symbolToId.put("plus", OperationIdentifier.ADD);
    symbolToId.put("add", OperationIdentifier.ADD);
    symbolToId.put("-", OperationIdentifier.SUBTRACT);
    symbolToId.put("빼기", OperationIdentifier.SUBTRACT);
    symbolToId.put("*", OperationIdentifier.MULTIPLY);
    symbolToId.put("x", OperationIdentifier.MULTIPLY);
    symbolToId.put("곱하기", OperationIdentifier.MULTIPLY);
    symbolToId.put("/", OperationIdentifier.DIVIDE);
    symbolToId.put("%", OperationIdentifier.DIVIDE);
    symbolToId.put("나누기", OperationIdentifier.DIVIDE);

    idToSymbol.computeIfAbsent(OperationIdentifier.ADD, key -> new ArrayList<>()).add("+");
    idToSymbol.computeIfAbsent(OperationIdentifier.ADD, key -> new ArrayList<>()).add("더하기");
    idToSymbol.computeIfAbsent(OperationIdentifier.SUBTRACT, key -> new ArrayList<>()).add("-");
    idToSymbol.computeIfAbsent(OperationIdentifier.SUBTRACT, key -> new ArrayList<>()).add("빼기");
    idToSymbol.computeIfAbsent(OperationIdentifier.MULTIPLY, key -> new ArrayList<>()).add("*");
    idToSymbol.computeIfAbsent(OperationIdentifier.MULTIPLY, key -> new ArrayList<>()).add("x");
    idToSymbol.computeIfAbsent(OperationIdentifier.MULTIPLY, key -> new ArrayList<>()).add("곱하기");
    idToSymbol.computeIfAbsent(OperationIdentifier.DIVIDE, key -> new ArrayList<>()).add("/");
    idToSymbol.computeIfAbsent(OperationIdentifier.DIVIDE, key -> new ArrayList<>()).add("%");
    idToSymbol.computeIfAbsent(OperationIdentifier.DIVIDE, key -> new ArrayList<>()).add("나누기");
  }

  public Optional<OperationIdentifier> getIdentifier(String symbol) {
    try {
      return Optional.ofNullable(this.symbolToId.get(symbol));
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  public Optional<String> getSymbol(OperationIdentifier id) {
    try {
      return Optional.ofNullable(this.idToSymbol.get(id).get(0));
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}

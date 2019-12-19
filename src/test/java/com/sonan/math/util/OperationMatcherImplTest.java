package com.sonan.math.util;

import static org.junit.jupiter.api.Assertions.*;

import com.sonan.math.util.operation.OperationIdentifier;
import com.sonan.math.util.operation.OperationMatcher;
import com.sonan.math.util.operation.OperationMatcherImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * @github: http://github.com/sonanDev
 * @createdBy: jindam91@gmail.com
 * @created: 2019-12-20
 * @since: 1.8
 */
class OperationMatcherImplTest {

  @DisplayName("symbol로 ADD identifier를 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"+", "더하기", "add", "plus"})
  void getAddIdentifier(String symbol) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getIdentifier(symbol).ifPresent((id) -> assertEquals(id, OperationIdentifier.ADD));
  }

  @DisplayName("symbol로 SUBTRACT identifier를 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"-", "빼기"})
  void getSubtractIdentifier(String symbol) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getIdentifier(symbol).ifPresent((id) -> assertEquals(id, OperationIdentifier.SUBTRACT));
  }

  @DisplayName("symbol로 MULTIPLY identifier를 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"*", "곱하기", "x"})
  void getMultiplyIdentifier(String symbol) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getIdentifier(symbol).ifPresent((id) -> assertEquals(id, OperationIdentifier.MULTIPLY));
  }

  @DisplayName("symbol로 DIVIDE identifier를 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"/", "나누기", "%"})
  void getDivideIdentifier(String symbol) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getIdentifier(symbol).ifPresent((id) -> assertEquals(id, OperationIdentifier.DIVIDE));
  }


  @DisplayName("ADD identifier로 symbol을 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"ADD"})
  void getAddSymbol(String id) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getSymbol(OperationIdentifier.valueOf(id)).ifPresent((symbol) -> assertEquals(symbol, "+"));
  }


  @DisplayName("SUBTRACT identifier로 symbol을 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"SUBTRACT"})
  void getSubtractSymbol(String id) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getSymbol(OperationIdentifier.valueOf(id)).ifPresent((symbol) -> assertEquals(symbol, "-"));
  }

  @DisplayName("MULTIPLY identifier로 symbol을 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"MULTIPLY"})
  void getMultiplySymbol(String id) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getSymbol(OperationIdentifier.valueOf(id)).ifPresent((symbol) -> assertEquals(symbol, "*"));
  }

  @DisplayName("DIVIDE identifier로 symbol을 얻어낸다.")
  @ParameterizedTest
  @CsvSource({"DIVIDE"})
  void getDivideSymbol(String id) {
    OperationMatcher matcher = OperationMatcherImpl.getInstance();
    matcher.getSymbol(OperationIdentifier.valueOf(id)).ifPresent((symbol) -> assertEquals(symbol, "/"));
  }
}
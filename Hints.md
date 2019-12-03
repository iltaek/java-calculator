# 기능 분리 힌트
* 테스트할 수 있는 단위로 나누어 구현 목록을 정의한다.
  * 덧셈, 곱셈, 뺄셈, 나눗셈
  * 입력 값이 null이거나 공백 문자일 경우, IllegalArgumentException throw
  * 사칙 연산 기호가 아닐 경우, IllegalArgumentException throw
* 사용자 입력을 공백 문자열을 기준으로 분리하려면 String 클래스의 split(" ") 메서드를 활용한다.

# JUnit, AssertJ 구현 힌트
## Exception 구현 힌트
* [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion) 문서 참고
```java
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

assertThatExceptionOfType(IndexOutOfBoundsException.class)
  .isThrownBy(() -> {
      // ...
}).hasMessageMatching("Index: \\d+, Size: \\d+");
```
* 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
  * assertThatIllegalArgumentException()
  * assertThatIllegalStateException()
  * assertThatIOException()
  * assertThatNullPointerException()
```java
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

assertThatIllegalArgumentException().isThrownBy(() -> {
    // ...
});
```
## 테스트 데이터 전달
* [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 문서 참고
```java
@ParameterizedTest
@ValueSource(strings = {"", "  "})
void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
    assertTrue(Strings.isBlank(input));
}
```

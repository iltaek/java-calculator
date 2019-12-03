# 계산기
## 진행 방법
* 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 Push 한다.

## 기능 요구사항
* 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
* 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
  * 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
  * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

### 실행 결과
```
계산할 식을 입력하세요. (각 문자열은 공백( )으로 구분)
2 + 3 * 4 / 2
10.0
```

## 프로그래밍 요구사항
* 메서드가 여러 일을 하지 않도록 한다.
  * 메서드가 여러 일을 한다면 메서드를 분리한다.

## 참고할 문서
* [기능 구현과 JUnit, AssertJ 구현 힌트](./Hints.md)
* [코드 리뷰 프로세스](./CodeReviewProcess.md)
* [Google Code Convention](https://google.github.io/styleguide/javaguide.html) 문서
  * [Google Code Style Guide](https://github.com/google/styleguide) 에서 `intellij-java-google-style.xml` 받을 수 있음.

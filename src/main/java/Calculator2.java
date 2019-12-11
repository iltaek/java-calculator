import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator2 {

  private static List<String> OPERATIONS = Arrays.asList("+", "-", "*", "/");

  public static double calculate(String expression) {
    Stack<String> stack = new Stack<>();
    for (String argument : expression.split(" ")) {
      if (stack.isEmpty()) {
        if (OPERATIONS.contains(argument)) {
          throw new IllegalArgumentException();
        } else {
          stack.push(argument);
        }
      } else {
        if (OPERATIONS.contains(argument)) {
          if (OPERATIONS.contains(stack.peek())) {
            throw new IllegalArgumentException();
          } else {
            stack.push(argument);
          }
        } else {
          if (OPERATIONS.contains(stack.peek())) {
            String operation = stack.pop();
            Double operand = Double.parseDouble(stack.pop());
            Double sum = calculate(operation, operand, Double.parseDouble(argument));
            stack.push(sum.toString());
          } else {
            throw new IllegalArgumentException();
          }
        }
      }
    }
    return Double.parseDouble(stack.pop());
  }

  private static Double calculate(String operation, Double a, Double b) {
    switch (operation) {
      case "+":
        return a + b;
      case "-":
        return a - b;
      case "*":
        return a * b;
      case "/":
        return a / b;
      default:
        throw new IllegalArgumentException();
    }
  }
}

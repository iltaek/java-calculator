import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class Calculator {

    public double calculate(String expression) {
        final List<String> arguments = Arrays.asList(expression.split(" "));

        Verifier.checkValidation(arguments);

        final Queue<Operator> operators = Operator.findOperators(arguments);

        return arguments.stream()
            .filter(o -> !Operator.findByName(o).isPresent())
            .map(Double::parseDouble)
            .reduce((a, b) -> Objects.requireNonNull(operators.poll()).method.apply(a, b))
            .orElseThrow(() -> new IllegalArgumentException("계산에 실패했습니다."));
    }
}

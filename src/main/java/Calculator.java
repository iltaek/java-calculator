import com.google.common.base.Preconditions;
import lombok.AllArgsConstructor;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class Calculator {

    @AllArgsConstructor
    enum Operator {
        ADD("+", Double::sum),
        SUBTRACT("-", (a, b) -> a - b),
        MULTIPLY("*", (a, b) -> a * b),
        DIVIDE("/", (a, b) -> a / b);

        String name;
        BinaryOperator<Double> method;

        static Optional<Operator> findByName(String name) {
            return Arrays.stream(Operator.values())
                    .filter(v -> v.name.equals(name))
                    .findFirst();
        }
    }

    public double calculate(String expression) {
        final List<String> arguments = Arrays.asList(expression.split(" "));
        checkValidation(arguments);
        final Queue<Operator> operators = arguments
                .stream()
                .map(Operator::findByName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toCollection(LinkedList::new));
        return arguments.stream()
                .filter(o -> !Operator.findByName(o).isPresent())
                .map(Double::parseDouble)
                .reduce((a, b) -> Objects.requireNonNull(operators.poll()).method.apply(a, b))
                .orElseThrow(RuntimeException::new);
    }

    private void checkValidation(List<String> arguments) {
        Preconditions.checkArgument(arguments.size()%2 == 1);
        int i;
        for (i = 0; i < arguments.size() && Operator.findByName(arguments.get(i)).isPresent() == (i%2 == 1); i++);
        Preconditions.checkArgument(arguments.size() == i);
    }
}

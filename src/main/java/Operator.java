import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public enum Operator {
    ADD("+", Double::sum),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    String name;
    BinaryOperator<Double> method;

    Operator(String name, BinaryOperator<Double> method) {
        this.name = name;
        this.method = method;
    }

    static Optional<Operator> findByName(String name) {
        return Arrays.stream(Operator.values())
            .filter(v -> v.name.equals(name))
            .findFirst();
    }

    static Queue<Operator> findOperators(List<String> arguments) {
        return arguments
            .stream()
            .map(Operator::findByName)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
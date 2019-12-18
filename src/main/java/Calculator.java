import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

public class Calculator {

    public double calculate(String expression) {
        final List<String> arguments = Arrays.asList(expression.split(" "));
        Verifier.checkValidation(arguments);
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
            .orElseThrow(IllegalArgumentException::new);
    }

}

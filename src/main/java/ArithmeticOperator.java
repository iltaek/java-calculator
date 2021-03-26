import java.util.Arrays;
import java.util.function.Function;

public enum ArithmeticOperator {
    PLUS("+" :: equals,
            (augend, addend) -> augend + addend),
    MINUS("-" :: equals,
            (augend, addend) -> augend - addend),
    MULTIPLY("*" :: equals,
            (augend, addend) -> augend * addend),
    DIVIDE("/" :: equals,
        (augend, addend) -> augend / addend);

    Function<String, Boolean> operationIdentifier;
    Operation operation;

    ArithmeticOperator(Function<String, Boolean> operationIdentifier, Operation operation) {
        this.operationIdentifier = operationIdentifier;
        this.operation = operation;
    }

    public static double operate(double augend, String arithmeticOperator, double addend) {
        ArithmeticOperator correspondingOperator = Arrays.stream(ArithmeticOperator.values())
                .filter(operator -> operator.isCorrespondingOperator(arithmeticOperator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Operation format error."));

        return correspondingOperator.getOperationResult(augend, addend);
    }

    public boolean isCorrespondingOperator(String numberOperator) {
        return operationIdentifier.apply(numberOperator);
    }

    public double getOperationResult(double augend, double addend) {
        return operation.calculate(augend, addend);
    }

    public interface Operation {
        double calculate(double augend, double addend);
    }
}

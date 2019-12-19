import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public enum ArithmeticOperator {
    PLUS("+" :: equals,
            stream -> stream.reduce((x, y) -> x + y).get()),
    MINUS("-" :: equals,
            stream -> stream.reduce((x, y) -> x - y).get()),
    MULTIPLY("*" :: equals,
            stream -> stream.reduce((x, y) -> x * y).get()),
    DIVIDE("/" :: equals,
            stream -> stream.reduce((x, y) -> x / y).get());

    Function<String, Boolean> operationIdentifier;
    Function<Stream<Double>, Double> arithmeticOperation;

    ArithmeticOperator(Function<String, Boolean> operationIdentifier, Function<Stream<Double>, Double> arithmeticOperation) {
        this.operationIdentifier = operationIdentifier;
        this.arithmeticOperation = arithmeticOperation;
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
        return arithmeticOperation.apply(Stream.of(augend, addend));
    }
}

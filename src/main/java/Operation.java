import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public enum Operation {
    ADDITION("+", (a,b) -> a+b),
    SUBTRACTION("-", (a,b) -> a-b),
    MULTIPLICATION("*", (a,b) -> a*b),
    DIVISION("/", (a,b) -> a/b);

    private String symbol;
    private BiFunction<Double, Double, Double> fn;

    Operation(String symbol, BiFunction<Double, Double, Double> fn) {
        this.symbol = symbol;
        this.fn = fn;
    }

    public static Operation getValueBySymbol(String targetSymbol) throws IllegalArgumentException {
        return Stream.of(Operation.values()).filter(o -> o.symbol.equals(targetSymbol)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getSymbol() {
        return symbol;
    }

    Double apply(Number a, Number b) {
        return fn.apply(a.doubleValue(), b.doubleValue());
    }
}

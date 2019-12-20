import Function.BinaryFunction;
import Function.Division;

import java.util.stream.Stream;

public enum BinaryOperator {
    ADDITION("+", (a,b) -> a.doubleValue()+b.doubleValue()),
    SUBTRACTION("-", (a,b) -> a.doubleValue()-b.doubleValue()),
    MULTIPLICATION("*", (a,b) -> a.doubleValue()*b.doubleValue()),
    DIVISION("/", new Division());

    private String symbol;
    private BinaryFunction fn;

    BinaryOperator(String symbol, BinaryFunction fn) {
        this.symbol = symbol;
        this.fn = fn;
    }

    public static BinaryOperator getValueBySymbol(String targetSymbol) throws IllegalArgumentException {
        return Stream.of(BinaryOperator.values()).filter(o -> o.symbol.equals(targetSymbol)).findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getSymbol() {
        return symbol;
    }

    Number apply(Number a, Number b) {
        return fn.execute(a, b);
    }
}
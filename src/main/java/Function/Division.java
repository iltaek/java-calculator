package Function;

import java.math.BigDecimal;

public class Division implements BinaryFunction {

    @Override
    public Number execute(Number a, Number b) throws ArithmeticException {
        if (isZero(b)) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a.doubleValue() / b.doubleValue();
    }

    static private boolean isZero(Number number) {
        return BigDecimal.ZERO.compareTo(BigDecimal.valueOf(number.doubleValue())) == 0;
    }
}

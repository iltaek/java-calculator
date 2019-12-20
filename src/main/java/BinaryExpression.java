public class BinaryExpression {
    private final BinaryOperator operator;
    private final BinaryExpression leftOperand;
    private final BinaryExpression rightOperand;
    private Number value;

    BinaryExpression(String[] expr, int startIndex) {
        this.rightOperand = new BinaryExpression(Double.parseDouble(expr[startIndex]));
        this.operator = BinaryOperator.getValueBySymbol(expr[startIndex-1]);
        if (startIndex - 2 == 0) {
            this.leftOperand = new BinaryExpression(Double.parseDouble(expr[0]));
        } else {
            this.leftOperand = new BinaryExpression(expr, startIndex - 2);
        }
    }

    BinaryExpression(Number value) {
        this.operator = null;
        this.leftOperand = null;
        this.rightOperand = null;
        this.value = value;
    }

    public Number getValue() {
        if (value != null) return value;

        return value = operator.apply(leftOperand.getValue(), rightOperand.getValue());
    }
}

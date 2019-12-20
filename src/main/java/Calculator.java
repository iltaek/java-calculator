public class Calculator {
    private static String BLANK = " ";
    private final String input;

    Calculator(String input) {
        this.input = input;
    }

    public Number calculate() throws IllegalArgumentException {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("계산할 식이 입력되지 않았습니다.");
        }

        String[] splitExpr = input.split(BLANK);
        if (splitExpr.length % 2 == 0) {
            throw new IllegalArgumentException("잘못된 식이 입력되었습니다.");
        }

        final BinaryExpression expr;
        try {
            expr = new BinaryExpression(splitExpr, splitExpr.length - 1);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 식이 입력되었습니다.");
        }

        return expr.getValue();
    }
}
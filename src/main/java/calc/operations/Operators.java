package calc.operations;

import java.util.HashMap;

public enum Operators {
    PLUS("+", new Addition()),
    MINUS("-", new Subtraction()),
    MULTIPLY("*", new Multiplication()),
    DIVIDE("/", new Division());

    private static final HashMap<String, Operators> OP_LABEL = new HashMap<>();

    static {
        for (Operators op : values()) {
            OP_LABEL.put(op.toString(), op);
        }
    }

    private String operator;
    private Operation operation;

    Operators(String operator, Operation operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static Operators getOperation(String op) {
        return OP_LABEL.get(op);
    }

    public double calculate(double op1, double op2) {
        return operation.calculate(op1, op2);
    }

    @Override
    public String toString() {
        return operator;
    }
}

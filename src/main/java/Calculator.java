import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;

public class Calculator {
    public static void main(String[] args) {

    }

    public double run(String input) {
        String[] elements = Optional.ofNullable(input)
                .orElseThrow(() -> new IllegalArgumentException("Blank input error."))
                .split(" ");

        checkValidation(elements);

        return calculate(elements);
    }

    private void checkValidation(String[] elements) {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Blank input error.");
        }

        if (elements.length % 2 == 0) {
            throw new IllegalArgumentException("Input length error.");
        }
    }

    private double calculate(String[] elements) {
        Iterator<String> iterator = Arrays.asList(elements)
                .iterator();
        double result = parseStringToDouble(iterator.next());

        while (iterator.hasNext()) {
            String arithmeticOperator = iterator.next();
            double addend = parseStringToDouble(iterator.next());

            result = ArithmeticOperator.operate(result, arithmeticOperator, addend);
        }

        return result;
    }

    private double parseStringToDouble(String element) {
        try {
            return Double.parseDouble(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number format error.");
        }
    }
}

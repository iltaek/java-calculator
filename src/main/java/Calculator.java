

public class Calculator {
    public static void main(String[] args) {

    }

    public double run(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Blank input error");
        }

        String[] elements = input.split(" ");

        checkValidation(elements);

        double result = parseStringToDouble(elements[0]);

        for (int i = 1; i < elements.length; i = i + 2) {
            if (elements[i].equals("+")) {
                result += parseStringToDouble(elements[i + 1]);
            } else if (elements[i].equals("-")) {
                result -= parseStringToDouble(elements[i + 1]);
            } else if (elements[i].equals("*")) {
                result *= parseStringToDouble(elements[i + 1]);
            } else if (elements[i].equals("/")) {
                result /= parseStringToDouble(elements[i + 1]);
            } else {
                throw new IllegalArgumentException("Operation format error");
            }
        }

        return result;
    }

    private void checkValidation(String[] elements) {
        if (elements.length == 0) {
            throw new IllegalArgumentException("Blank input error.");
        }

        if (elements.length % 2 == 0) {
            throw new IllegalArgumentException("Input length error.");
        }
    }

    public double parseStringToDouble(String element) {
        try {
            return Double.parseDouble(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Number format error");
        }
    }
}

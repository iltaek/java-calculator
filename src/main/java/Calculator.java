import java.util.*;

public class Calculator {
    private static String BLANK = " ";

    public static void main(String[] args) {
        String msg = "계산할 식을 입력하세요. (각 문자열은 공백(" + BLANK + ")으로 구분)";
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        try {
            System.out.println(calculate(expr));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static Object opConverter(String s) throws NumberFormatException {
        try {
            return Operation.getValueBySymbol(s);
        } catch (IllegalArgumentException e) {
            return Double.parseDouble(s);
        }
    }

    public static Number calculate(String expr) throws IllegalArgumentException {
        if (expr == null || expr.isEmpty())
            throw new IllegalArgumentException("계산할 식이 입력되지 않았습니다.");

        List<String> exprList = Arrays.asList(expr.split(BLANK));
        Collections.reverse(exprList);
        Stack<Object> opList= new Stack<Object>();

        try {
            exprList.forEach(s -> opList.add(opConverter(s)));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 식이 입력되었습니다.");
        }

        try {
            while (opList.size() > 1) {
                Number a = (Number) opList.pop();
                Operation operation = (Operation) opList.pop();
                Number b = (Number) opList.pop();

                opList.push(operation.apply(a,b));
            }
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("잘못된 식이 입력되었습니다.");
        }

        return (Number) opList.pop();
    }
}
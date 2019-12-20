import java.util.Scanner;

public class CalculatorView {


    public static void main(String[] args) {
        String msg = "계산할 식을 입력하세요. (각 문자열은 공백( )으로 구분)";
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        String expr = scanner.nextLine();
        Calculator calc = new Calculator(expr);
        try {
            System.out.println(calc.calculate());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

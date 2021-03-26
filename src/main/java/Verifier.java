import com.google.common.base.Preconditions;
import java.util.List;

class Verifier {

    static void checkValidation(List<String> arguments) {
        Preconditions.checkArgument(arguments.size() % 2 == 1, "입력값이 잘못됐습니다. (숫자와 연산자의 개수가 맞지 않음)");
        boolean operatorTurn = false;
        for (String argument : arguments) {
            if (Operator.findByName(argument).isPresent() == operatorTurn) {
                operatorTurn = !operatorTurn;
            } else {
                throw new IllegalArgumentException("입력값이 잘못됐습니다. (숫자와 연산자가 연속으로 입력됨)");
            }
        }
    }
}

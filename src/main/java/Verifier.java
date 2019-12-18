import com.google.common.base.Preconditions;
import java.util.List;

class Verifier {

    static void checkValidation(List<String> arguments) {
        Preconditions.checkArgument(arguments.size() % 2 == 1);
        int i;
        for (i = 0;
            i < arguments.size() && Operator.findByName(arguments.get(i)).isPresent() == (i % 2
                == 1);
            i++) {
            ;
        }
        Preconditions.checkArgument(arguments.size() == i);
    }
}

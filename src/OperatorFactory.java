import java.util.Random;

public class OperatorFactory {

    private Node[] operators;

    public OperatorFactory(Node[] operators) {
        this.operators = operators;
    }

    public Node getOperator(Random rand) {
        int index = rand.nextInt(operators.length);
        return operators[index].copy();
    }
}

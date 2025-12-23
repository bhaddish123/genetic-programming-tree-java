import java.util.Random;

public class TerminalFactory {

    private int numVars;

    public TerminalFactory(int numVars) {
        this.numVars = numVars;
    }

    public Node getTerminal(Random rand) {
        if (rand.nextBoolean()) {
            return new Variable(rand.nextInt(numVars));
        } else {
            return new Const(rand.nextDouble() * 10);
        }
    }
}

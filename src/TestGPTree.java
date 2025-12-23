import java.util.Random;

public class TestGPTree {

    static int numIndepVars = 3;
    static int maxDepth = 5;
    static Random rand = new Random();

    public static void main(String[] args) {

        double[] data = {3.14, 2.78, 1.0};

        Node[] ops = {
            new Plus(new Const(0), new Const(0)),
            new Minus(new Const(0), new Const(0)),
            new Mult(new Const(0), new Const(0)),
            new Divide(new Const(0), new Const(1))
        };

        OperatorFactory o = new OperatorFactory(ops);
        TerminalFactory t = new TerminalFactory(numIndepVars);

        GPTree gpt1 = new GPTree(o, t, maxDepth, rand);
        System.out.println(gpt1 + " = " + gpt1.eval(data));

        GPTree gpt2 = new GPTree(o, t, maxDepth, rand);
        System.out.println(gpt2 + " = " + gpt2.eval(data));

        gpt1.crossover(gpt2, rand);

        System.out.println("After crossover:");
        System.out.println(gpt1 + " = " + gpt1.eval(data));
        System.out.println(gpt2 + " = " + gpt2.eval(data));
    }
}

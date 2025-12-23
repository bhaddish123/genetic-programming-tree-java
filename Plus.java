public class Plus extends Binop {

    public Plus(Node left, Node right) {
        super(left, right);
    }

    @Override
    public double eval(double[] data) {
        return lChild.eval(data) + rChild.eval(data);
    }

    @Override
    public String toString() {
        return "(" + lChild + " + " + rChild + ")";
    }
}

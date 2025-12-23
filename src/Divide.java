public class Divide extends Binop {

    public Divide(Node left, Node right) {
        super(left, right);
    }

    @Override
    public double eval(double[] data) {
        double divisor = rChild.eval(data);
        if (Math.abs(divisor) < 0.0001) {
            return 1.0;
        }
        return lChild.eval(data) / divisor;
    }

    @Override
    public String toString() {
        return "(" + lChild + " / " + rChild + ")";
    }
    @Override
    public Node copy() {
    return new Divide(lChild.copy(), rChild.copy());
}
}

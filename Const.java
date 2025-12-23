public class Const extends Node {

    private double value;

    public Const(double value) {
        this.value = value;
    }

    @Override
    public double eval(double[] data) {
        return value;
    }

    @Override
    public void traverse(Collector c) {
        c.collect(this);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}

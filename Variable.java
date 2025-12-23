public class Variable extends Node {

    private int index;

    public Variable(int index) {
        this.index = index;
    }

    @Override
    public double eval(double[] data) {
        return data[index];
    }

    @Override
    public void traverse(Collector c) {
        c.collect(this);
    }

    @Override
    public String toString() {
        return "x" + index;
    }
}

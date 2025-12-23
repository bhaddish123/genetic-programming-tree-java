public abstract class Node {

    // Evaluate this node using input variables
    public abstract double eval(double[] data);

    // Allow this node to be visited during a tree traversal
    public abstract void traverse(Collector c);

}

public abstract class Binop extends Node {

    protected Node lChild;
    protected Node rChild;

    public Binop(Node left, Node right) {
        this.lChild = left;
        this.rChild = right;
    }

    @Override
    public void traverse(Collector c) {
        // preorder traversal
        c.collect(this);
        lChild.traverse(c);
        rChild.traverse(c);
    }
}

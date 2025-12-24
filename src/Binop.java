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
    @Override
    public abstract Node copy();

    @Override
public void addRandomKids(OperatorFactory o,
                          TerminalFactory t,
                          int maxDepth,
                          java.util.Random rand) {

    if (maxDepth <= 0) return;

    lChild = rand.nextBoolean()
            ? o.getOperator(rand)
            : t.getTerminal(rand);

    rChild = rand.nextBoolean()
            ? o.getOperator(rand)
            : t.getTerminal(rand);

    lChild.addRandomKids(o, t, maxDepth - 1, rand);
    rChild.addRandomKids(o, t, maxDepth - 1, rand);
}
}

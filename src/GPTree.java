import java.util.ArrayList;
import java.util.Random;

public class GPTree implements Collector {

    private Node root;
    private ArrayList<Binop> crossNodes;
    
    /**
     * Collect nodes during traversal.
     * Only Binop nodes are stored for crossover.
     */
    public void collect(Node node) {
        if (node instanceof Binop) {
            crossNodes.add((Binop) node);
        }
    }
    
    /**
     * Initializes the list and traverses the tree.
     */
    public void traverse() {
        crossNodes = new ArrayList<>();
        root.traverse(this);
    }
    
    /**
     * Returns all crossover nodes as a string.
     */
    public String getCrossNodes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < crossNodes.size(); i++) {
            sb.append(crossNodes.get(i));
            if (i < crossNodes.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    /**
     * Performs subtree crossover between two trees.
     */
    public void crossover(GPTree other, Random rand) {
        this.traverse();
        other.traverse();

        Binop thisNode = crossNodes.get(rand.nextInt(crossNodes.size()));
        Binop otherNode = other.crossNodes.get(rand.nextInt(other.crossNodes.size()));

        if (rand.nextBoolean()) {
            Node temp = thisNode.lChild;
            thisNode.lChild = otherNode.lChild;
            otherNode.lChild = temp;
        } else {
            Node temp = thisNode.rChild;
            thisNode.rChild = otherNode.rChild;
            otherNode.rChild = temp;
        }
    }

    public GPTree() {
        root = null;
    }

    public GPTree(OperatorFactory o, TerminalFactory t, int maxDepth, Random rand) {
        root = o.getOperator(rand);
        root.addRandomKids(o, t, maxDepth, rand);
    }

    public double eval(double[] data) {
        return root.eval(data);
    }

    public String toString() {
        return root.toString();
    }
}

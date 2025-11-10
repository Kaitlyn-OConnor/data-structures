import java.util.List;
import java.util.ArrayList;

/**
    A tree in which each node has an arbitrary number of children.
*/
public class Tree
{
    private Node root;
    
    static class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int total = 1; // starts at 1 so includes current node
            for (Node child: this.children)
            {
                 total += child.size();
            }
            return total;
        }
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        this.root = new Node();
        this.root.data = rootData;
        this.root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        this.root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size() 
    {
        return this.root.size();
    }

    // Additional methods will be added in later sections.
    /*
     * A visitor method is called for each visited node during a tree traversal
     */
    public interface Visitor {
        /*
         * The visit method is called for each visited node
         * @param data: The data of the node being visited
         */
        void visit(Object data);
    }

    /*
     * Traverse this tree in preorder.
     * @param v: the visitor to be invoked on each node
     */
    public void preorder(Visitor v)

    {
        Tree.preorder(this.root, v);
    }
     /*
      * Traverse the tree with a given root in preorder (preorder helper method)
      * @param n: the root of the tree to travers
      @ param v: The visitor to be invoked on each node
      */
      private static void preorder(Node n, Visitor v)
      {
        if (n == null)
            return;

        v.visit(n.data);

        for (Node child: n.children)
        {
            Tree.preorder(child, v);
        }
      }


      public void depthFirst(){
        depthFirstHelper(root);
      }

      public void depthFirstHelper(Node node){
        if (node == null) {
            return;
      }
        for (Node child: node.children) {
            depthFirstHelper(child);
          }
    }

      public static void postOrder(Node n, Visitor v)
      {
        if (n == null){
            return;
        }

        for (Node child: n.children) {
            Tree.postOrder(child, v);
            }
    
        v.visit(n.data);
    
      }

      public void postOrder(Visitor v) {
        Tree.postOrder(this.root, v);
      }
    


}

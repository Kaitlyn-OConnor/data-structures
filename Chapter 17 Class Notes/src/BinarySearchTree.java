/**
    This class implements a binary search tree whose
    nodes hold objects that implement the Comparable
    interface.
*/
public class BinarySearchTree
{   
    private Node root;

    /**
        Constructs an empty tree.
    */
    public BinarySearchTree()
    {   
        this.root = null;
    }
    
    /**
        Inserts a new node into the tree.
        @param obj the object to insert
    */
    public void add(Comparable obj) 
    {   
        Node newNode = new Node();
        newNode.data = obj;
        newNode.left = null;
        newNode.right = null;

        if (this.root == null)
            this.root = newNode;
        else
            this.root.addNode(newNode); // will only add if there is already a root that equals something
    }

    /**
        Tries to find an object in the tree.
        @param obj the object to find
        @return true if the object is contained in the tree
    */
    public boolean find(Comparable obj)
    {
        Node current = this.root;
        while (current != null) // if get to bottom of a path current will become null and the thing won't be found we we return false
        {
            int diff = obj.compareTo(current.data);
            if (diff == 0)
                return true; // found what were looking for because compareTo is 0
            else if (diff < 0)
                current = current.left;
            else
                current = current.right;
        }
        return false;
    }
    
    /**
        Tries to remove an object from the tree. Does nothing
        if the object is not contained in the tree.
        @param obj the object to remove
    */
    public void remove(Comparable obj)
    {
        Node toBeRemoved = this.root;
        boolean found = false;
        Node parent = null;

        while (!found && toBeRemoved != null)
        {
            int diff = obj.compareTo(toBeRemoved.data);
            if (diff == 0)
                found = true;
            else if (diff < 0){
                parent = toBeRemoved;
                toBeRemoved = toBeRemoved.left;
            }
            else {
                parent = toBeRemoved;
                toBeRemoved =  toBeRemoved.right;
            {
        }
        if (!found)
            return; // thing wanted to remove isn't there
        
         // Case 1 and Case 2 (at least 1 child is null)
        if (toBeRemoved.left == null || toBeRemoved.right == null)
        {
            Node newChild;

            if (toBeRemoved.left == null)
            {
                newChild = toBeRemoved.right;
            }
            else
                newChild = toBeRemoved.left;
            
            // Remove the root if the parent is null
            if (parent == null)
            {
                this.root = newChild;
            }
            else {
                parent.right = newChild;
            }

            return;

            // Case 3: Remove a node with 2 children and find the least element of the right subtree, since least element will replace removed node
            Node leastParent = toBeRemoved;
            Node least = toBeRemoved.right;

            while (least.left != null)
            {
                leastParent = least;
                least = least.left; // moving down the right subtree to the left as far as we can to get the smallest value greater than the removed node
            }

            // move the data to the node being removed
            toBeRemoved.data = least.data;
            // unlink the least child from its past spot
            if (leastParent == toBeRemoved)
            {
                leastParent.right = least.right; 
            }
            else 
            {
                leastParent.left = least.right;
            }
        }
    }
    
    /**
        Prints the contents of the tree in sorted order.
    */
    public void print()
    {   
        // print the tree using inorder traveral
        print(this.root);
        System.out.println();
    }   

    /**
        Prints a node and all of its descendants in sorted order.
        @param parent the root of the subtree to print
    */
    private static void print(Node parent)
    {   
        if (parent == null)
        {
            return;
        }

        print(parent.left); // first goes down the left side
        System.out.println(parent.data + " " ); // prints the root
        print(parent.right); // now goes down the right side
    }

    /**
        A node of a tree stores a data item and references
        to the left and right child nodes.
    */
    static class Node
    {   
        public Comparable data; // MUST BE comparable and not object because can't compare objects
        public Node left;
        public Node right;

        /**
            Inserts a new node as a descendant of this node.
            @param newNode the node to insert
        */
        public void addNode(Node newNode)
        {   
            // if diff < 0, new Node is to the left of this node and if diff > 0 then its to the right of this node
            int diff = newNode.data.compareTo(data);
            if (diff < 0)
            { // adds the new to left only if there isn't a node there already otherwise checks where it should put it for the left child node
                if (left == null)
                    left = newNode;
                else
                    left.addNode(newNode);
            }
            else if (diff > 0) // use else if so it doesn't include duplicates anywhere
            {
                if (right == null)
                    right = newNode;
                else    
                    right.addNode(newNode);
            }
        }
    }
}




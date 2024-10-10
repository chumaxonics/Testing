package algorithms;// Java implementation to check whether a binary
// tree is a full binary tree or not
import java.util.*;

class FullBinaryTreeORNot {

    // structure of a node of binary tree
    static class Node {
        int data;
        Node left, right;

        Node (int data){
            this.data=data;
            this.left =this.right=null;
        }
    }

    // function to get a new no

    // function to check whether a binary tree
// is a full binary tree or not 
    static boolean isFullBinaryTree(Node root)
    {
        // if tree is empty
        if (root == null)
            return true;

        // queue used for level order traversal
        Queue<Node> q = new LinkedList<Node> ();

        // push 'root' to 'q'
        q.add(root);

        // traverse all the nodes of the binary tree
        // level by level until queue is empty
        while (!q.isEmpty()) {
            // get the pointer to 'node' at front
            // of queue
            Node node = q.peek();
            q.remove();

            // if it is a leaf node then continue
            if (node.left == null && node.right == null)
                continue;

            // if either of the child is not null and the
            // other one is null, then binary tree is not
            // a full binary tee
            if (node.left == null || node.right == null)
                return false;

            // push left and right childs of 'node'
            // on to the queue 'q'
            q.add(node.left);
            q.add(node.right);
        }

        // binary tree is a full binary tee
        return true;
    }

    // Driver program to test above
    public static void main(String[] args)
    {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        if (isFullBinaryTree(root))
            System.out.println("Yes");
        else
            System.out.println("No");
    }
    /*
Given a binary tree containing n nodes. The problem is to check whether the given binary tree is a full binary tree or not.
A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
 Conversely, there is no node in a full binary tree, which has only one child node.
Input :
           1
         /   \
        2     3
       / \
      4   5
Output : Yes

Input :
           1
         /   \
        2     3
       /
      4
Output :No
 */
} 

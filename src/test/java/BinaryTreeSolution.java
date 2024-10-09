class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        this.left = this.right =null;
    }
}
public class BinaryTreeSolution {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);
    }
}

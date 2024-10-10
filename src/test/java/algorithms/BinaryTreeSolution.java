package algorithms;

import java.util.ArrayList;
import java.util.List;

class Node{
    int data;
    Node left, right;
    public Node(int data){
        this.data=data;
        this.left = this.right =null;
    }
}

class LeftViewOfTree{
    int maxLevel=0;
    void leftView(Node root, int level, List<Integer> result){
        if(root==null){
            return;
        }
        if(maxLevel < level){
            result.add(root.data);
            maxLevel=level;
        }
        leftView(root.left,level+1, result);
        leftView(root.right,level+1, result);
    }
}
public class BinaryTreeSolution {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.right = new Node(6);

        List<Integer> result = new ArrayList<>();
        LeftViewOfTree treeInstance= new LeftViewOfTree();
        treeInstance.leftView(root,1,result);

        for (Integer integer:result)
          {
              System.out.println(integer + " ");

          }
    }
}

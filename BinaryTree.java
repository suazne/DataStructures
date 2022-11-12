//Suzanne Schouest CSC 2720 Lab 10
package lab10;
import java.util.LinkedList;
import java.util.Queue;
//Node class for tree nodes
class Node {
    int data;
    Node left, right;
    public Node(int item)
    {
        data = item;
        left = null;
        right = null;
    }
}
//BinaryTree Class w/method to print in level order
class BinaryTree {
    Node root;
    //method to print in level order given a binary tree
    void printLevelOrder()
    {
    	//create queue to hold tree values
        Queue<Node> q = new LinkedList<Node>();
        if (root == null) {
        	return;
        }
        //add root value to the queue to start
        q.add(root);
        //loop thru, adding node values to queue and removing/printing until empty
        while (q.size() > 0) {
        	//remove and print 'temp' node
            Node temp = q.remove();
            System.out.print(temp.data + " ");
            //relative to 'temp' node, enqueue child nodes
            //enqueue left child node
            if (temp.left != null) {
                q.add(temp.left);
            }//enqueue right child node          
            if (temp.right != null) {
                q.add(temp.right);
            }
        }
    }
    //MAIN method driver code
    public static void main(String args[])
    {
    	//our Binary Tree
        BinaryTree tree = new BinaryTree();
        //enter node values
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        //print node values in level order using method
        tree.printLevelOrder();
    }
}
/* TIME COMPLEXITY: O(n) we loop thru the number of nodes in the tree
 * SPACE COMPLEXITY: O(n) space complexity increases linearly as we add more nodes
 * TEST CASES: I made sure to avoid errors involving an empty queue in the
 * printLevelOrder method with an if block in line 24 (avoids inserting a null value
 * into the queue, and also avoids us doing level order traversal for an empty tree) 
 * as well as a base case in the while loop in line 30 (if the queue is empty, we 
 * will no longer perform any functions like .remove(), which would cause an error. 
 * Alternatively we could use .poll(), which would return a null value from an empty
 * queue).*/
/* goal: print the nodes in a binary tree in level order
 * method: using a queue, add and remove node values, printing upon removal
 */
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
 */

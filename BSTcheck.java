/* goal: check to see if a binary tree is a valid search tree
*  method: use in order traversal (store output in a dynamic array) and check if 
*  the array is in ascending order to confirm validity before notifying user
*/
import java.util.*;

//Node class for tree nodes
class Node {
    int data;
    Node left, right;
    public Node(int item){
    	data = item;
    	left = null;
	    right = null;
	}
}
//BSTcheck class with methods to convert BST to arraylist and check if valid BST
public class BSTcheck {
	static Node root;
	//traverses in-order thru a binary tree and returns arraylist with values
	static ArrayList<Integer> inOrderTraversal(Node node)
    {
		//initialize arraylist to hold search tree values in level order
        ArrayList<Integer> bstArray = new ArrayList<Integer>();
        //create a stack to hold node values
        Stack<Node> stk = new Stack<Node>();
        //temporary variable to hold nodes/their data
        Node temp = root;
        //go thru nested while loop if the node value (root) is not null
        while (temp != null || stk.size() > 0) {
        	while (temp != null) {
        		//push temp value onto the stack
        		stk.push(temp);
        		//redefine temp value as left child of temp
        		temp = temp.left;
        	}
        	//at this point the temp node value must be null after internal loop
        	//redefine temp value as whatever is in the stack
        	temp = stk.pop();
        	//add temp.data to the arraylist
        	bstArray.add(temp.data);
        	//move on to the right subtree for the next iteration of external loop
        	temp = temp.right;
        }
        //after traversal (or lack thereof, if temp (root) was initiall null) return array
        return bstArray;
    }
	//checks if an arraylist is sorted or not
	static boolean isSorted(ArrayList<Integer> array) {
		int n = array.size();
	    //if the arraylist has one or zero elements, it is sorted
	    if (n == 0 || n == 1) {
	    	return true;
	    }
	    //iterate thru entire arraylist
	    for (int i = 1; i < n; i++) {
	    	//if an  unsorted pair is found, return false
	    	if (array.get(i - 1) > array.get(i)) {
	        	return false;
	        }	
	    }
	    //after passing thru and seeing no unsorted pairs, return true
	    return true;
	}
    //returns boolean true if the tree is a BST and false if not
    static Boolean isBST(ArrayList<Integer> array) {  
        //return boolean value true for sorted false for not sorted
        return isSorted(array);  
    }
	//MAIN method driver code
    public static void main(String args[])
    {
    	//new tree
    	BSTcheck tree = new BSTcheck();
    	//assign values to each node
    	tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        System.out.println("BST in order traversal: ");
        //print arraylist representation of BST
        ArrayList<Integer> bstArray = inOrderTraversal(tree.root);
        for (int i = 0; i < bstArray.size(); i++)
            System.out.print(bstArray.get(i) + " ");
        //notify user if the BST is valid or not
        if (isBST(bstArray) == true) {
        	System.out.println("\nThis is a valid BST");
        }else {
        	System.out.println("\nThis is not a valid BST");
        }
    }
}
/* TIME COMPLEXITY: O(n) because we iterate thru each node when we traverse through
 * the BST to convert it to an array in-order. Note we are also using a stack here.
 * Additionally, we iterate thru each index in the arraylist when we check to see if
 * it is sorted, so we end up with linear time complexity.
 * SPACE COMPLEXITY: O(n) As stated above, we create and use a stack in one of our
 * methods to traverse through the array in-order, so we know that we are at linear
 * space complexity here. As the size of the input grows, the space required will 
 * increase linearly, just as time needed will linearly increase as well. 
 */

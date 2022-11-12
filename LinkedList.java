//Suzanne Schouest CSC 2720 Lab 7
package lab7;

public class LinkedList {
     
    class Node {// Node class
        int data;//data variable (for what's inside the nodes)
        Node next;//next node
        Node(int d){//class constructor
            this.data = d;//the data in the node 
            this.next = null;//next node is null
        }
    }	
    static Node head = null; //head of the linked list
    public void add(int d){//our own written method to add nodes
    	Node temp = new Node(d);//hold data in temporary node
    	if (head == null) {//if the head is null, meaning the LinkedList is empty so far
    		head = temp;//make new node with data d the head node
    	}else {//once we have the head node
    		Node dummy = head;//create a dummy node
    		while(dummy.next != null) {//while the node after the dummy node is not null
    			dummy = dummy.next;//dummy is equal to the next node after dummy
    		}
    		dummy.next = temp;//the node after the dummy node becomes the temp node for next loop thru
    	}
    }
    static void deleteNode(LinkedList mylist, int n) {//method to delete nth node from end
    	if (head == null) {//if null, output invalid notification
    		System.out.println("Input is invalid. List is empty.");
    		return;
    	}
    	else if (head.next == null) {//if the list is too short, output invalid notification
    		System.out.println("Input is invlaid. Input must be longer.");
    	}
    	else {//after test cases, move forward with setting pointers
    		Node dummy = head;//initialize dummy node
            Node slow = dummy;//slow pointer  		
            Node fast = head;//fast pointer
            for (int i = 0; i < n; i++) {//loop thru while index < our n value
                fast = fast.next;//fast pointer moves 1 step ahead per loop
            }//at end of loop, pointer moves forward n steps
            if (fast == null) {//if after loop, the pointer is null
                  head = head.next;//move the head to the next node in list
                return;//break out of method
            }
            while (fast.next != null) {//while the fast pointer's next val us not null
                fast = fast.next;//increment by one step
                slow = slow.next;//increment by one step 
            }
            slow.next = slow.next.next;//redefine slow's next as slow's next-next so as to delete the necessary node
            return;
    	}
    }
    public static void printList(LinkedList mylist){//print the linkedlist (self-explanatory)
        Node i = head;
        while (i != null) { //loop thru nodes until null
            System.out.print(i.data + " ");//print each node's data
            i = i.next;//go to next node to print
        }
    }
	public static void main(String[] args) {
		LinkedList mylist = new LinkedList();
		//add our values as assigned in assignment 
        mylist.add(50);
        mylist.add(11);
        mylist.add(33);
        mylist.add(21);
        mylist.add(40);
        mylist.add(71);
        //print out our original linked list
        System.out.println("Original LinkedList:");
        printList(mylist);
        //pick which node we will delete then delete it with method
        int n = 2;
        deleteNode(mylist, n);
        //print out new linkedlist order
        System.out.println("\nLinkedList after Deletion:");
        printList(mylist);
	}

}

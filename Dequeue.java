//Suzanne Schouest Lab 9 CSC 2720
package lab9;
import java.util.*;
import java.util.LinkedList;
public class Dequeue{
    //creating queue and arraydeque
    Queue<Integer> q;
    ArrayDeque<Integer> dq;

    //constructor for the class
    Dequeue() {
        q = new LinkedList<>();
        dq = new ArrayDeque<>();
    }

    void enqueue(int d){
        //find position of the element in the dequeue and insert it
        while(!dq.isEmpty() && dq.getLast() < d){
            //remove the last element from dequeue
            dq.removeLast();
        }
        //add the element at the end
        dq.addLast(d);
        q.add(d);
    }

    void deque(){
        //return the last element of the dequeue
        if(dq.getFirst() == q.peek()){
            dq.removeFirst();
        }
        q.remove();
    }

    //get max element from the queue
    int getMax() throws Exception{
        //check if the element is empty
        if(q.isEmpty())//TEST: TEST CASE TO MAKE SURE QUE IS NOT EMPTY
            throw new Exception("Queue is Empty");
        else
            return dq.getFirst();//return max: first element in dq
    }

    //main method
    public static void main(String[] args) throws Exception {
        Dequeue dq = new Dequeue();
        while(true){//print menu items
            System.out.println("Menu Options ");
            System.out.println("a) Enqueue");
            System.out.println("b) Deque");
            System.out.println("c) Return Max");
            System.out.println("d) Quit");
            
            Scanner s = new Scanner(System.in);
            char choice = s.next().charAt(0);
            if(choice == 'a'){
                System.out.println("Enter the element");
                int n = s.nextInt();//take input
                dq.enqueue(n);//add element
            }
            else if(choice == 'b'){//remove element
                System.out.println("Element is removed");
                dq.deque();
            }else if(choice == 'c'){//return max
                System.out.println("The max-element is " + dq.getMax());
            }else if(choice == 'd') {
            	break;//quit 
            }
        }
    }
}
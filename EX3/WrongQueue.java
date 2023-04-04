import java.util.Arrays;
import java.util.Random;


/**
   An example of bad programming
 **/
public class WrongQueue {
    class Node{
        String data;
        Node next;
    }
    
    private Node head;
    private Node current;
    private Node last;

    
    public void enqueue(String str){
        Node nnode = new Node();            // initialize new node
        nnode.data = str;                   // give the node some data
        if(head == null){                   // if there is no nodes in the queue
            current = last = head = nnode;  // each pointer points to the same node
        }else{                              // if the new node is not alone 
            last.next = nnode;              // pointer to last.next is updated
            last = nnode;                   // and last points to next
            if(current == null)             // if current 
            current = nnode;                // 
        }
    }

    public String dequeue(){
        String result = null;
        
        if(current != null){
            result = current.data;
            current = current.next;
            head = current;                 //this assignement was missing, which is mandatory to make the garbage collector works
        }

	    return result;
	    
    }

    
    public static void main(String[] args){
        Random rnd = new Random();
        WrongQueue queue = new WrongQueue();
        final int SIZE = 1024*1024;

        for(int i=0; i < 5000000; ++i){
            if(i % 2 == 0){
                char[] chars = new char[SIZE];
                Arrays.fill(chars, 'f');
                queue.enqueue("String n. " + rnd.nextInt(101) + new String(chars));
            } else
                System.out.printf("Dequeue \"%s\"\n", queue.dequeue().substring(0,15));
            try{
                Thread.sleep(200);
            }catch(InterruptedException e){}
        }
    }
}

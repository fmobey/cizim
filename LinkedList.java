

import java.util.ArrayList;

public class LinkedList<T> {
    private int numberOfNodes = 0; 
    private ListNode<T> front = null;
    

    public boolean isEmpty() {
        return (front == null);
    }
    

    public void makeEmpty() {
        front = null;
        numberOfNodes = 0;
    }

    public int size() {
        return numberOfNodes;
    }

    public void addFront( T element ) {
        front = new ListNode<T>( element, front );
        numberOfNodes++;
    }

    public T peek() {
        if (isEmpty()) 
            return null;
        
        return front.getData();
    }
    

    public T removeFront() {
        T tempData;
        
        if (isEmpty()) 
            return null;
        
        tempData = front.getData();
        front = front.getNext();
        numberOfNodes--;
        return tempData;
    }
    

    public void removeEnd(T element) {
        ListNode<T> node=front;
        while(node.getNext() != null)
        {
            node = node.getNext();
        }
        node.setNext(new ListNode<T>((T)element, null));
    }
    

    public ArrayList<T> getArray() {
        
        ArrayList<T> shapeArray=new ArrayList<T>();
        
        ListNode<T> node=front;
        while (node!=null)
        {
            shapeArray.add(node.getData());
            node = node.getNext();
        }
        
        return shapeArray;
    }
}

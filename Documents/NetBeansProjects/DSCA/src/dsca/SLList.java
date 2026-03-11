/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public class SLList implements LinkedListInterface{
    private Node head;
    private Node curr;
    private Node prev;
    private Node size;

    public SLList() {
        size = 0;
        head = null;
        curr = null;
        prev = null;
    }
    
    @Override
    public boolean isEmpty(){
        if(size == 0){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int size(){
        return size;
    }
    
    
    
    public void addStop(int index, Object element){
        if(index == 1){
            Node newNode = new Node(element, head);
            head = newNode;
            
        } else if(head == null){
            Node newNode = new Node(element);
            head = newNode;
        } else {
            setCurrentStop(index);
            Node newNode = new Node(element, curr);
            newNode.next = curr.next;
            curr.next = newNode;
        }
        size++;
    }
       private void setCurrentStop(int index){
       
        curr = head;  
        prev = null;
        for(int i = 1; i < index; i++){
            prev = curr;
            curr = curr.getNext();

        }
    }
    @Override
    public void removeStop(int index){
        
        if(index == 1){
            head = head.getNext();
        }else{
            setCurrentStop(index);
            curr = curr.getNext();
            prev.next = curr;

        }
        size--;  //reduce counter by 1
    }

    public void printStopList(){
        Node aNode = head;
        while ( aNode != null ) {
              System.out.println(aNode.getElement().toString());
              aNode = aNode.getNext();
       }
    }
    
    
    
}

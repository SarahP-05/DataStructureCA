/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public class Node { //Node class
    protected Object element;
    protected Node next;

    public Node() { //empty constructor
    }
    
    public Node(Object element) { //full constructor
        this.element = element;
        next  = null;
    }

    public Node(Object element, Node next) { //full constructor no. 2
        this.element = element;
        this.next = next;
    }

    //getters and setters
    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    //toString method
    @Override
    public String toString() {
       // return "Node{" + "element=" + element + ", next=" + next + '}';
       return element.toString();
    }
    
    
    
}

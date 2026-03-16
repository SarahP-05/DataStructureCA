/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public class PQElement { //PQ Methods
    private int priorityKey; //pq variable
    private Object element; //pq variable
    
    public PQElement(int priorityKey, Object element){ //full constructor
        this.priorityKey = priorityKey;
        this.element = element;
    }
    
    //getters & setterss

    public int getPriorityKey() { 
        return priorityKey;
    }

    public Object getElement() {
        return element;
    }

    public void setPriorityKey(int priorityKey) {
        this.priorityKey = priorityKey;
    }

    public void setElement(Object element) {
        this.element = element;
    }
    
    

    //to String Method
    @Override
    public String toString() {
        return "PQElement{" + "priorityKey=" + priorityKey + ", element=" + element + '}';
    }
    
    
    
}

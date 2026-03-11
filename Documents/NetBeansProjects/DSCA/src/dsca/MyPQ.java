/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public class MyPQ implements PQInterface{
    private SLList stops;

    public MyPQ() {
        stops = new SLList();
    }
    
      @Override
    public boolean isEmpty() {
        return stops.isEmpty();
    }

    @Override
    public int size() {
        return stops.size();
    }

    @Override
    public void enqueue(int priorityKey, Object element) {
        PQElement elem = new PQElement(priorityKey, element);

        if (stops.isEmpty()) {
            stops.addStop(1, elem);
            return;
        }

        Node current = stops.getHead();
        Node prev = null;
        int index = 1;

        while (current != null) {
            PQElement temp = (PQElement) current.getElement();
            if (temp.getPriorityKey() < priorityKey) {
                break; // insert here
            }
            prev = current;
            current = current.getNext();
            index++;
        }

        stops.addStop(index, elem);
    }

     @Override
    public Object dequeue() {
        if (stops.isEmpty()) return null;
        PQElement elem = (PQElement) stops.getHead().getElement();
        stops.removeStop(1);
        return elem.getElement(); // return the stored object (stop name)
    }

    @Override
    public Object frontOfQueue() {
        if (stops.isEmpty()) return null; 
            PQElement elem = (PQElement) stops.getHead().getElement();
         return elem.getElement();
    }
    
     // print queue
    public String printQ() {
        Node current = stops.getHead();
        StringBuilder str = new StringBuilder();
        while(current != null) {
            PQElement elem = (PQElement) current.getElement();
            str.append("Key: ").append(elem.getPriorityKey())
               .append(" elem: ").append(elem.getElement()).append("\n");
            current = current.getNext();
        }
        return str.toString();
    }
    
}

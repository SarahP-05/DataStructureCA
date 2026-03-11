/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */

// Tutorials I watched to better understand PQ & SLL: https://www.youtube.com/watch?v=mcMXy4EH0MQ
//                                                    https://www.youtube.com/watch?v=fRhbFTOBqjA

public class MyPQ implements PQInterface{
    private SLList stops;

    public MyPQ() { //initialises new SLList
        stops = new SLList();
    }
    
      @Override
    public boolean isEmpty() { //checks to see if SLList is empty
        return stops.isEmpty();
    }

    @Override
    public int size() { //returns size of SLList to user
        return stops.size();
    }

//    @Override
    public void enqueue(int priorityKey, Object element) { //adds stop Name and Number to Stop PQ
        PQElement elem = new PQElement(priorityKey, element);

        if (stops.isEmpty()) {
            stops.addStop(1, elem);
            return;
        }

        Node current = stops.getHead();
        Node prev = null;
        int index = 1;

        while (current != null) { //while current is filled in...
            PQElement temp = (PQElement) current.getElement(); 
            if (temp.getPriorityKey() > priorityKey) { //smaller numbers first to show stop duration
                break; // insert here
            }
            prev = current; //changes prev to current
            current = current.getNext(); //and current to next one
            index++; //increases size of pq
        }

        stops.addStop(index, elem); //adds the inputted information into the stop SLL
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
            str.append("Minutes: ").append(elem.getPriorityKey())
               .append("Stop Name: ").append(elem.getElement()).append("\n");
            current = current.getNext();
        }
        return str.toString();
    }
    
}

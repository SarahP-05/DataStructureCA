package dsca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Bus class stores bus information and stops using a Priority Queue backed by a Singly Linked List.
 */
public class Bus {

    private String busName;
    private String busNumber;
    private MyPQ stops; // PQ storing stops (priority = key, stopName = element)

    // Static HashMap storing all buses by bus number
    private static HashMap<String, Bus> buses = new HashMap<>();

    // ---------------- Constructor ----------------
    public Bus(String busName, String busNumber) {
        this.busName = busName;
        this.busNumber = busNumber;
        stops = new MyPQ();
    }

    // ---------------- Getters ----------------
    public String getBusName() {
        return busName;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public MyPQ getStops() {
        return stops;
    }

    // ---------------- Bus Methods ----------------

    /** Add a stop with priority */
    public void addStop(int priority, String stopName) {
        stops.enqueue(priority, stopName);
    }

    /** Remove the highest priority stop */
    public void removeStop() {
        stops.dequeue();
    }

    /** Display route for this bus (console) */
    public void displayRoute() {
        System.out.println("Bus: " + busName + " (" + busNumber + ")");
        System.out.println(stops.printQ());
    }

    // ---------------- HashMap Methods ----------------

    /** Add this bus to the static buses HashMap */
    public void addToSystem() {
        buses.put(busNumber, this);
    }

    /** Get a bus by bus number */
    public static Bus getBus(String busNumber) {
        return buses.get(busNumber);
    }

    /** Return all buses in the system */
    public static HashMap<String, Bus> getAllBuses() {
        return buses;
    }

    // ---------------- Display Methods ----------------

    /** Returns all buses and their stops as a formatted string */
    public static String getAllBusesInfo() {
        StringBuilder sb = new StringBuilder();

        for (Bus bus : buses.values()) {
            sb.append("Bus: ").append(bus.getBusName())
              .append(" (").append(bus.getBusNumber()).append(")\n");

            Node current = bus.getStops().getStopsList().getHead(); // access SLList
            while (current != null) {
                PQElement elem = (PQElement) current.getElement();
                sb.append("  Due: ").append(elem.getPriorityKey())
                  .append(" Stop Name: ").append(elem.getElement()).append("\n");
                current = current.getNext();
            }
            sb.append("-------------------------\n");
        }
        return sb.toString();
    }

    // ---------------- StopInfo Search ----------------

    /** Class to store search result for a stop */
    public static class StopInfo {
        public String busNumber;
        public String busName;
        public int priorityKey;

        public StopInfo(String busNumber, String busName, int priorityKey) {
            this.busNumber = busNumber;
            this.busName = busName;
            this.priorityKey = priorityKey;
        }
    }

    

public static String findStopInfo(String stopName) {

    ArrayList<StopInfo> matches = new ArrayList<>();

    for (Bus bus : buses.values()) {

        Node current = bus.getStops().getStopsList().getHead();

        while (current != null) {

            PQElement elem = (PQElement) current.getElement();

            if (elem.getElement().toString().equals(stopName)) {

                matches.add(new StopInfo(
                        bus.getBusNumber(),
                        bus.getBusName(),
                        elem.getPriorityKey()
                ));
            }

            current = current.getNext();
        }
    }

    if(matches.isEmpty()){
        return "No buses found for this stop.";
    }

    
    Collections.sort(matches, Comparator.comparingInt(s -> s.priorityKey));

    StringBuilder result = new StringBuilder();

    for(StopInfo s : matches){
        result.append("Bus: ")
              .append(s.busName)
              .append(" (")
              .append(s.busNumber)
              .append(") Due in: ")
              .append(s.priorityKey)
              .append("\n");
    }

    return result.toString();
}
}
package dsca;

//all imports needed:
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;



public class Bus { //bus class

    private String busName; 
    private String busNumber;
    private MyPQ stops; // PQ storing stops (priority = key, stopName = element)

    // Static HashMap storing all buses by bus number
    private static HashMap<String, Bus> buses = new HashMap<>();

        //constructor
    public Bus(String busName, String busNumber) {
        this.busName = busName;
        this.busNumber = busNumber;
        stops = new MyPQ();
    }

    //getters and setters
    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }
    
    

    public String getBusNumber() {
        return busNumber;
    }

    public MyPQ getStops() {
        return stops;
    }

    //Bus Methods

    //adds stopname w/ priority with enqueue.
    public void addStop(int priority, String stopName) {
        stops.enqueue(priority, stopName);
    }

    //removes stop w/ dequeue
    public void removeStop() {
        stops.dequeue();
    }

    
    public void displayRoute() {
        System.out.println("Bus: " + busName + " (" + busNumber + ")");
        System.out.println(stops.printQ());
    }

    // Hashmap Methods to search Stops

    /** Add this bus to the static buses HashMap */
    public void addToSystem() {
        buses.put(busNumber, this);
    }

    /** Gets a bus by bus number */
    public static Bus getBus(String busNumber) {
        return buses.get(busNumber);
    }

    /** Return all buses in the system */
    public static HashMap<String, Bus> getAllBuses() {
        return buses;
    }

    // Displays All buses/Stops methods

    /** Returns all buses and their stops as a string */
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
        return sb.toString(); //returns the string to the method and displays it where called
    }
    
    public String getBusInfo() { //gets all bus info and displays it
    StringBuilder sb = new StringBuilder();
    sb.append("Bus Number: ").append(busNumber).append("\n");
    sb.append("Bus Name: ").append(busName).append("\n");
    sb.append("Stops:\n");

    Node current = stops.getStopsList().getHead();
    while(current != null){
        PQElement elem = (PQElement) current.getElement();
        sb.append("Priority ").append(elem.getPriorityKey()).append(": ").append(elem.getElement()).append("\n");
        current = current.getNext();
    }

    return sb.toString();
}

    // Stop information Search

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
    
    public static boolean deleteBus(String busNumber) { //deletes bus if called
    if (buses.containsKey(busNumber)) {
        buses.remove(busNumber);  // Remove from memory
        saveAllBusesToFile("src/dsca/busData.txt"); // Persist changes
        return true;
    } else {
        return false;
    }
}
 
    

public static String findStopInfo(String stopName) { //find all information on the stops - priority, name, etc.

    ArrayList<StopInfo> matches = new ArrayList<>(); //store matching info with arraylist

    for (Bus bus : buses.values()) { //iterates through all buses in system

        Node current = bus.getStops().getStopsList().getHead(); //get head of sll of stops for bus

        while (current != null) { //while its not null it goes through this while loop

            PQElement elem = (PQElement) current.getElement(); //get stop element from node

            if (elem.getElement().toString().equals(stopName)) { //check if stop matches the search name

                matches.add(new StopInfo(
                        bus.getBusNumber(),
                        bus.getBusName(),
                        elem.getPriorityKey()
                ));
            }

            current = current.getNext(); //move to next stop in list
        }
    }

    if(matches.isEmpty()){ //if nothing is found:
        return "No buses found for this stop.";
    }

    //sorts the priority keys in  ascending order
    Collections.sort(matches, Comparator.comparingInt(s -> s.priorityKey));

    StringBuilder result = new StringBuilder(); //builds a string of results

    for(StopInfo s : matches){ //sends the matching bus info to the results string
        result.append("Bus: ")
              .append(s.busName)
              .append(" (")
              .append(s.busNumber)
              .append(") Due in: ")
              .append(s.priorityKey)
              .append("\n");
    }

    return result.toString(); //return the results
}


       public static void saveAllBusesToFile(String filePath) { //saves all buses to the txt file

    try {

        java.io.PrintWriter pw = new java.io.PrintWriter(new java.io.FileWriter(filePath));

        for (Bus bus : buses.values()) { //goes through all buses

            Node current = bus.getStops().getStopsList().getHead(); //gets head of stops in sll

            while (current != null) { //goes through each stop

                PQElement elem = (PQElement) current.getElement(); //get stop element

                pw.println( //prints to file in this format
                        bus.getBusNumber() + "," +
                        bus.getBusName() + "," +
                        elem.getPriorityKey() + "," +
                        elem.getElement()
                );

                current = current.getNext(); //moves to next stop
            }
        }

        pw.close(); //closes once bus is saved to file

    } catch (Exception e) { //catches any errors that occur and sends to console
        e.printStackTrace();
    }
}
       
       public static void loadBusesFromFile(String filePath) { //loads info from text file
    buses.clear(); // clear existing buses in memory (avoid duplicates)

    try (java.io.BufferedReader br = new java.io.BufferedReader(new java.io.FileReader(filePath))) {
        String line;
        while ((line = br.readLine()) != null) { //reads everything from file
            // Each line format: busNumber,busName,priority,stopName
            String[] parts = line.split(",", 4); //splits it into parts and ignores the ,
            if (parts.length < 4) continue; //skip invalid lines

            String busNumber = parts[0].trim(); //extracts bus no.
            String busName = parts[1].trim(); //gets bus name
            int priority = Integer.parseInt(parts[2].trim()); //gets the priority key
            String stopName = parts[3].trim(); //gets stop name

            // Check if bus already exists in System
            Bus bus = buses.get(busNumber);
            if (bus == null) { //if not, creates a new bus and adds it to system
                bus = new Bus(busName, busNumber);
                bus.addToSystem(); //adds bus to system
            }

            // Adds the stop to bus
            bus.addStop(priority, stopName);
        }
    } catch (Exception e) { //catches any errors.
        e.printStackTrace();
    }
}
}
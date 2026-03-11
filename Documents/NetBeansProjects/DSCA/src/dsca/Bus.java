package dsca;

public class Bus {

    String busName;
    String busNumber;
    MyPQ stops; // PQ stores stops

    public Bus(String busName, String busNumber){
        this.busName = busName;
        this.busNumber = busNumber;
        stops = new MyPQ();
    }

    // Add a stop with priority
    public void addStop(int priority, String stopName){
        stops.enqueue(priority, stopName);
    }

    // Remove highest priority stop
    public void removeStop(){
        stops.dequeue();
    }

    // Display all stops
    public void displayRoute(){
        System.out.println("Bus: " + busName + " (" + busNumber + ")");
        System.out.println(stops.printQ());
    }
}
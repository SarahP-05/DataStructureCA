package dsca;

public class Bus { //Creates Object bus

    String busName; //takes in busname
    String busNumber; //takes in busnumber
    MyPQ stops; // PQ stores stops

    public Bus(String busName, String busNumber){ //full constructor
        this.busName = busName;
        this.busNumber = busNumber;
        stops = new MyPQ(); //initialises SLL for PQ
    }

    // Add a stop with priority number
    public void addStop(int priority, String stopName){
        stops.enqueue(priority, stopName); //in this case it's 'Minutes' and 'Stop Name' - Will be shown in GUI TA
    }

    // Removes the highest priority stop
    public void removeStop(){
        stops.dequeue(); //goes to dequeue method for PQ
    }

    // Display all stops
    public void displayRoute(){ //displays Bus information then prints out PQ
        System.out.println("Bus: " + busName + " (" + busNumber + ")");
        System.out.println(stops.printQ());
    }
}
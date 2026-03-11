/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */

// Tutorials I watched to better understand PQ & SLL: https://www.youtube.com/watch?v=mcMXy4EH0MQ
//                                                    https://www.youtube.com/watch?v=fRhbFTOBqjA
public class DSCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // Create Bus System (list of buses)
        SLList busList = new SLList();

        // Create buses
        Bus bus1 = new Bus("City Centre Loop", "46A");
        Bus bus2 = new Bus("Airport Express", "16");

        // Add stops to bus1 (priority, stop name)
        bus1.addStop(5, "Stillorgan");
        bus1.addStop(3, "UCD");
        bus1.addStop(1, "Donnybrook");

        // Add stops to bus2
        bus2.addStop(4, "Airport");
        bus2.addStop(2, "Drumcondra");
        bus2.addStop(6, "O'Connell Street");

        // Add buses to the bus list
        busList.addStop(1, bus1);
        busList.addStop(2, bus2);

        // Display all buses and their stops
        System.out.println("=== Bus Routes ===\n");
        Node currentBusNode = busList.getHead();
        while (currentBusNode != null) {
            Bus bus = (Bus) currentBusNode.getElement();
            bus.displayRoute();
            System.out.println();
            currentBusNode = currentBusNode.getNext();
        }

        // Remove the highest priority stop from bus1
        System.out.println("Removing highest priority stop from bus1...\n");
        bus1.removeStop();

        // Display buses again to see the change
        System.out.println("=== Bus Routes After Removing Stop ===\n");
        currentBusNode = busList.getHead();
        while (currentBusNode != null) {
            Bus bus = (Bus) currentBusNode.getElement();
            bus.displayRoute();
            System.out.println();
            currentBusNode = currentBusNode.getNext();
        }
    }
    
}

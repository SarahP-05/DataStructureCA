/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsca;

import java.io.File;
import java.util.Scanner;

/**
 *
 * @author sarah
 */

// Tutorials I watched to better understand PQ & SLL: https://www.youtube.com/watch?v=mcMXy4EH0MQ
//                                                    https://www.youtube.com/watch?v=fRhbFTOBqjA

public class DSCA { //Main Class

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
         new FirstJFrame().setVisible(true); //sets First Frame Visible
          
        
        loadFromFile("src/dsca/busData.txt"); //loads Text File into program
        Bus.getAllBusesInfo(); //Puts all info to a String so Later it can be called upon to populate Text Areas
    }
    
    public static void loadFromFile(String filename){ //method to read the txt file

    try{

        Scanner sc = new Scanner(new File(filename)); //uses a scanner to read the txt file 

        while(sc.hasNextLine()){ //while it has a next line in the txt file

            String line = sc.nextLine();

            if(line.trim().isEmpty()) continue;

            String[] data = line.split(","); //ignores the , symbol in the txt file

            //File Layout: busNumber, busName, priority, stop
            String busNumber = data[0]; 
            String busName = data[1];
            int priority = Integer.parseInt(data[2]);
            String stop = data[3];

            Bus bus = Bus.getBus(busNumber);//makes new bus with info

            if(bus == null){ //if bus is null then
                bus = new Bus(busName, busNumber); //bus is new bus
                bus.addToSystem(); //adds bus to system
            }

            bus.addStop(priority, stop); //adds stops to PQ
        }

        sc.close(); //ends scanner

    }catch(Exception e){ //if error with reading file then:
        System.out.println("Error reading file");
    }
}
}

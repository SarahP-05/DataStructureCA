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

public class DSCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         new FirstJFrame().setVisible(true);
          
        
        loadFromFile("src/dsca/busData.txt");
        Bus.getAllBusesInfo();
    }
    
    public static void loadFromFile(String filename){

    try{

        Scanner sc = new Scanner(new File(filename));

        while(sc.hasNextLine()){

            String line = sc.nextLine();

            if(line.trim().isEmpty()) continue;

            String[] data = line.split(",");

            String busNumber = data[0];
            String busName = data[1];
            int priority = Integer.parseInt(data[2]);
            String stop = data[3];

            Bus bus = Bus.getBus(busNumber);

            if(bus == null){
                bus = new Bus(busName, busNumber);
                bus.addToSystem();
            }

            bus.addStop(priority, stop);
        }

        sc.close();

    }catch(Exception e){
        System.out.println("Error reading file");
    }
}
}

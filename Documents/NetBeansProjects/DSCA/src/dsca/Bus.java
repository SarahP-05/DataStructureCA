/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public class Bus {
    String busName;
    String busNumber;
    SLList stops;
    
    public Bus(String busName, String busNumber){
        this.busName = busName;
        this.busNumber = busNumber;
        stops = new SLList();
    }
    
    public void addStop(String stopName){
    stops.add(stopName);
}
    
    public void displayRoute(){
        System.out.println(busName + " " + busNumber + " Route:");
        stops.displayStops(); 
    }
    
}

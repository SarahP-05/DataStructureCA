/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public class DSCA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Bus bus1 = new Bus("City Centre Loop", "46A");
        bus1.addStop(5, "Stillorgan");
        bus1.addStop(3, "UCD");
        bus1.addStop(1, "Donnybrook");
        bus1.displayRoute();
    }
    
}

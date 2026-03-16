/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public interface LinkedListInterface { //methods to be called upon through a diff class
    public boolean isEmpty();
    public int size();  
    public void removeStop(int index);
    public void addStop(int index, Object e);
}

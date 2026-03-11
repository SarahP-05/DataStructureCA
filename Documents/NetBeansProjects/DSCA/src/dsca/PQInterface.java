/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsca;

/**
 *
 * @author sarah
 */
public interface PQInterface {
    public void enqueue(int priorityKey, Bus newBus);
    public Object dequeue();
    public Object frontOfQueue();
    public int size();
    public boolean isEmpty();
}

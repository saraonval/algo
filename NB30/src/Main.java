/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author saraonval
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Heap heap = new Heap(10);
        
        
        heap.insert("Äpple");
        heap.insert("Banan");
        heap.insert("Päron");
        
        heap.print();
    }
    
}

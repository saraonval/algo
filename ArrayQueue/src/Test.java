/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author saraonval
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayQueue<String> nameQ = new ArrayQueue<String>(10);
        
        for(int i=0; i<8; i++) {
            nameQ.offer("e" + (i+1));
        }
        
        nameQ.poll();
        nameQ.poll();
        
        for(int i=8; i<14; i++) {
            nameQ.offer("e" + (i+1));
        }
        
        while(nameQ.peek() != null) {
            System.out.println(nameQ.poll());
        }
    }
    
}

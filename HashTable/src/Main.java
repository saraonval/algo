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

    public static void main(String[] args) {
	// write your code here
        HashTableBucket htb = new HashTableBucket(2);
        String[] colors = {"Blue", "Red", "Yellow", "Green", "Pink", "Purple", "Black", "Grey", "White", "Gold"};
        for(int i=0; i<colors.length; i++) {
            htb.put(i, colors[i]);
        }
        System.out.println(htb);
        
        /*

        HashTableBucket<Integer, Integer> table = new HashTableBucket<>(10);
        for (int i = 0; i < 50; i+=1) {
            int test = (int) (Math.random()*50);
            table.put(test,test);
        }
        //System.out.println(table);
        /*for (int i = 0; i < 100; i++) {
            if(i%3==0)
                table.remove(i);
        }
        //System.out.println(table);
        //System.out.println(table.get(22));
        
        System.out.println(table);
        
        */
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author @author Sara Onval, onval@kth.se
 */
public class Max {
    
    // vi skickar in size som parameter och inte som lokal variabel
    // för annars kommer den lokala variabeln att nollställas varje gång metoden anropas
    // inte så vi vill göra i en rekursiv metod
    public static int maxValue(int[] values, int size) {
        System.out.println("Size: " + size);
        if (size == 0) {
            return 1;
        }
        else {
            // vi skickar in två värden i den privata maxValue metoden (som räknar ut max värdet mellan två ints)
            // den första är det sista talet i vår array, som minskar med tiden eftersom vi minskar på size med 1 varje gång
            // den andra är sig själv, där vi skickar in samma värden MEN size-1 varje gång
            // så size minskar varje gång vi kallar på metoden
            // till slut kommer size == 0, då kommer 1 returneras
            // när 1 returneras kommer vi klättre ner i "stacken"
            // nu kollar vi maxValue mellan sista elementet och 1
            // sedan kollar vi maxValue mellan det största av de med näst sista osv.
            // vi tömmer på metodanropen i stacktrace, och till slut får vi ut vårt önskade värde.
            return maxValue(values[size-1], maxValue(values, size-1));
        }
    }
    
    // privat metod, kollar max mellan två tal
    // wrappas in i den rekursiva metoden
    private static int maxValue(int value1, int value2) {
        if (value1 > value2) {
            return value1;
        }
        return value2;
    }
    
    public static void main(String[] args) {
        int[] values = {55, 4, 3, 22, 78, 1};
        System.out.println("Max value: " + maxValue(values, values.length));
    }
}

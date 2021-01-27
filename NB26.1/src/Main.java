
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
        String[] strings = {"grön", "röd", "blå", "blå", "hej", "gul", "hej", "hej"};
        System.out.println("Antalet gånger som den vanligaste strängen förekommer: " + getCommonString(strings));
    }

    public static int getCommonString(String[] strings) {
        //HashMap<String, Integer> map = putStringsInMap(strings);  // no recursion
        HashMap<String, Integer> map = new HashMap<>();
        map = putStringsInMapRec(map, strings, 0);    // recursion
        int max = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }
        return max;
    }

    // NOT RECURSION
    private static HashMap<String, Integer> putStringsInMap(String[] strings) {
        HashMap<String, Integer> map = new HashMap<>();
        // Put strings in map
        for (int i = 0; i < strings.length; i++) {
            // if the string is not present as a key
            if (map.get(strings[i]) == null) {
                // put a new entry with key = string
                map.put(strings[i], 1);
            } else {
                // otherwise, increment the value
                int value = map.get(strings[i]) + 1;
                map.put(strings[i], value);
            }
        }
        System.out.println(map);
        map = putStringsInMapRec(map, strings, 0);
        return map;
    }

    // RECURSION
    private static HashMap<String, Integer> putStringsInMapRec(HashMap<String, Integer> map, String[] strings, int index) {

        // if the string is not present as a key
        if (map.get(strings[index]) == null) {
            // put a new entry with key = string
            map.put(strings[index], 1);
        } else {
            // otherwise, increment the value
            int value = map.get(strings[index]) + 1;
            map.put(strings[index], value);
        }

        if (index == strings.length - 1) {
            System.out.println(map);
            return map;
        } else {
            // recursion
            return putStringsInMapRec(map, strings, index + 1);
        }

    }

}

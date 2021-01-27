/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package robot;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author user
 */
public class Robot {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char[] packet = {'A', 'B', 'C', 'D', 'E'};
        char[] example = {'B', 'E', 'C', 'A', 'D'};
        char[] shufflePacket = shufflePacket(packet);
        System.out.print("Ordning: " + Arrays.toString(shufflePacket));
        System.out.println("");
        System.out.println(orderPackets(shufflePacket).length() + " Steps: " + orderPackets(shufflePacket));
        System.out.println("Ordered: "  + Arrays.toString(packet));
    }
    
    public static String orderPackets(char[] packet){
        return orderPackets(packet, 0, "");
    }
    
    private static String orderPackets(char[] packet, int times, String result){
        char[] answer = {'A', 'B', 'C', 'D', 'E'};
        if(Arrays.equals(packet, answer)){
            return result;
        }
        else if(times > 15){
            return "failed to fix";
        }
        
        else{
            
            char[] tmpPacket1 = new char[packet.length];
            char[] tmpPacket2 = new char[packet.length];
            for(int i = 0; i < packet.length; i++){
                tmpPacket1[i] = packet[i];
                tmpPacket2[i] = packet[i];
            }
            
            String letterS = orderPackets(sConvert(tmpPacket1), times + 1, result + "s");
            String letterB = orderPackets(bConvert(tmpPacket2), times + 1, result + "b");
            
            if(letterB.length() < letterS.length()){
                return letterB;
            }
            
            else{
                return letterS;
            }
        }
    }
    private static char[] sConvert(char[] packet){
        char last = packet[packet.length - 1];
        for(int i = packet.length - 1; i > 0; i--){
            packet[i] = packet[i - 1];
        }
        packet[0] = last;
        return packet;
    }
    
    private static char[] bConvert(char[] packet){
        char first = packet[0];
        packet[0] = packet[1];
        packet[1] = first;
        return packet;
    }
    
    private static char[] shufflePacket(char[] packet) {
        Random rand = new Random();
        char[] tmpPacket = new char[packet.length];
        for(int i = 0; i < packet.length; i++){
            tmpPacket[i] = packet[i];
        }
        for(int i = 0; i < packet.length; i++){
            int randomPosition = rand.nextInt(packet.length);
            char tmpValue = tmpPacket[i];
            tmpPacket[i] = tmpPacket[randomPosition];
            tmpPacket[randomPosition] = tmpValue;
        }
        return tmpPacket;
    }
}
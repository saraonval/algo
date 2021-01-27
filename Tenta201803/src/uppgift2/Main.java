package uppgift2;

import java.util.*;

public class Main {
    
    private static class MarbleState {
        
        private final int noOfBlue, noOfRed, noOfWhite, noOfSwitches;
        
        public MarbleState(int noOfBlue, int noOfRed, int noOfWhite, int noOfSwitches) {
            this.noOfBlue = noOfBlue;
            this.noOfRed = noOfRed;
            this.noOfWhite = noOfWhite;
            this.noOfSwitches = noOfSwitches;
        }
        
        public boolean existBlue() {
            return noOfBlue > 0;
        }
        
        public boolean existRed() {
            return noOfRed > 0;
        }
        
        public boolean existWhite() {
            return noOfWhite > 0;
        }
        
        public MarbleState switchBlue() {
            if (noOfBlue <= 0) {
                return null;
            }
            return new MarbleState(noOfBlue-1, noOfRed+1, noOfWhite+3, noOfSwitches+1);
        }
        
        public MarbleState switchRed() {
            if (noOfRed <= 0) {
                return null;
            }
            return new MarbleState(noOfBlue+2, noOfRed-1, noOfWhite+1, noOfSwitches+1);
        }
        
        public MarbleState switchWhite() {
            if (noOfWhite <= 0) {
                return null;
            }
            return new MarbleState(noOfBlue+3, noOfRed+4, noOfWhite-1, noOfSwitches+1);
        }
        
        public boolean done() {
            return noOfBlue == noOfWhite && noOfBlue == noOfRed;
        }
    }

    public static void main(String[] args) {
        int nrOfBlue = 5, nrOfWhite = 1, nrOfRed = 3;
        System.out.println("Antal växlingar: " + nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed));
        nrOfBlue = 2;
        nrOfWhite = 1;
        nrOfRed = 3;
        System.out.println("Antal växlingar: " + nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed));
        nrOfBlue = 22;
        nrOfWhite = 22;
        nrOfRed = 13;
        System.out.println("Antal växlingar: " + nrOfSwitches(nrOfBlue, nrOfWhite, nrOfRed));
    }

    private static int nrOfSwitches(int nrOfBlue, int nrOfWhite, int nrOfRed) {
        Queue<MarbleState> q = new LinkedList<>();
        q.offer(new MarbleState(nrOfBlue, nrOfRed, nrOfWhite, 0));
        MarbleState currentState;
        
        while(!q.isEmpty()) {
            currentState = q.poll();
            
            if(currentState.done()) {
                return currentState.noOfSwitches;
            }
            
            if (currentState.noOfSwitches == 15) {
                return -1;
            }
            
            if (currentState.existBlue()) {
                q.offer(currentState.switchBlue());
            }
            
            if (currentState.existRed()) {
                q.offer(currentState.switchRed());
            }
            
            if (currentState.existWhite()) {
                q.offer(currentState.switchWhite());
            }
        }
        
        return -1;
    }

}

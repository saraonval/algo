
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sara Onval, onval@kth.se
 */
public class Coin {

    private static class State {
        int points, coins;
        public State(int position, int coins) {
            this.points = position;
            this.coins = coins;
        }
    }
    
    // start points = 1
    public static int coinMachine(int goalPoints) {
        Queue<State> q = new LinkedList<State>();
        State state = new State(1, 0);
        
        // Motsatsen till terminerande tillståndet
        while(state.points != goalPoints) {
            
            // Kolla om 10an går bra
            if (state.points * 3 <= goalPoints) {
                q.offer(new State(state.points*3, state.coins+10));
            }
            
            // Kolla om 5an går bra
            if (state.points + 4 <= goalPoints) {
                q.offer(new State(state.points+4, state.coins+5));
            }
            
            // Avköa första elementet i kön
            state = q.poll();
            // Kolla om det uppfyller tillståndet
            // Om inte, gå igenom loopen
            // Ända tills points == points
        }
        return state.coins;
    }

    public static void main(String[] args) {
        System.out.print("Vilken poäng ska uppnås: ");
        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        System.out.println("Poängen kan nås med " + coinMachine(points) + " öre");
    }
}

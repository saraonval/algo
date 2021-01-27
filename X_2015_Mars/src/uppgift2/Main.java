package uppgift2;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int t = -1;
        int[][] pyramid = {{5, t, t, t, t, t, t, t, t, t},
        {3, 1, t, t, t, t, t, t, t, t},
        {4, 7, 6, t, t, t, t, t, t, t},
        {6, 8, 0, 9, t, t, t, t, t, t},
        {9, 2, 3, 5, 4, t, t, t, t, t},
        {8, 0, 5, 6, 1, 2, t, t, t, t},
        {2, 9, 7, 1, 0, 3, 5, t, t, t},
        {0, 7, 1, 6, 2, 9, 4, 8, t, t},
        {6, 1, 5, 0, 4, 2, 7, 9, 3, t},
        {9, 3, 2, 7, 8, 6, 4, 1, 5, 0}};

        solve(pyramid);

    }
    
    private static void solve(int[][] pyramid) {
        boolean[] used = new boolean[pyramid.length];
        int[] order = new int[pyramid.length];
        if (solve(pyramid, used, order, 0, 0)) {
            System.out.println(Arrays.toString(order));
        }
        else {
            System.out.println("Olösbar!");
        }
    }
    
    private static boolean solve (int[][] pyramid, boolean[] used, int[] order, int n, int m) {
        if (used[pyramid[n][m]]) {
            return false;
        }
        used[pyramid[n][m]] = true;
        order[n] = pyramid[n][m];
        if (n == pyramid.length-1) {
            return true;
        }
        if (solve(pyramid, used, order, n+1, m)) {
            return true;
        }
        if (solve(pyramid, used, order, n+1, m+1)) {
            return true;
        }
        used[pyramid[n][m]] = false;
        return false;
    }

}

package uppgift1;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] talTriangel = {{7, -1, -1, -1, -1},
        {3, 8, -1, -1, -1},
        {8, 1, 0, -1, -1},
        {2, 7, 4, 4, -1},
        {4, 5, 2, 6, 5}};
        System.out.println(maxSumma(talTriangel));
    }

    public static int maxSumma(int[][] triangle) {
        int[][] tab = new int[triangle.length][triangle.length];
        for (int i=0; i<tab.length; i++) {
            for (int j=0; j<tab.length; j++) {
                tab[i][j] = -1;
            }
        }
        return maxSumma(triangle, 0, 0, tab);
    }
    
    private static int maxSumma(int[][] triangle, int n, int m, int[][] tab) {
        if (n == triangle.length) {
            return 0;
        }
        if (tab[n][m] >= 0) {
            return tab[n][m];
        }
        return tab[n][m] = Math.max(triangle[n][m] + maxSumma(triangle, n+1, m, tab), triangle[n][m] + maxSumma(triangle, n+1, m+1, tab));
    }
    
}

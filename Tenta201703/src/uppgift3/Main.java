package uppgift3;

public class Main {

    public static void main(String[] args) {
        System.out.println(findPaths(5, 6));
    }
    
    private static int findPaths(int row, int col) {
        int[][] tab = new int[row+1][col+1];
        tab[0][0] = 1;
        return findPaths(row, col, tab);
    }
    
    private static int findPaths(int row, int col, int[][] tab) {
        
        if (tab[row][col] != 0) {
            return tab[row][col];
        }
        
        int noOfPaths = 0;
        
        if (row > 0) {
            noOfPaths = findPaths(row-1, col, tab);
        }
        
        if (col > 0) {
            noOfPaths += findPaths(row, col-1, tab);
        }
        
        return noOfPaths;
    }
}
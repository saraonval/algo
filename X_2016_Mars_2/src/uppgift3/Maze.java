package uppgift3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Maze {

    private class Position {

        private int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public boolean equals(Position p) {
            return (p.row == row && p.col == col);
        }
    }

    Position currentP, goal;
    int rows, columns;
    int[][] mazeMatrix;

    public Maze() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("Labyrint.txt"));
            rows = Integer.parseInt(in.readLine()) + 2;
            columns = Integer.parseInt(in.readLine()) + 2;
            mazeMatrix = new int[rows][columns];
            for (int j = 0; j < columns; j++) {
                mazeMatrix[0][j] = 0;
                mazeMatrix[rows - 1][j] = 0;
            }
            for (int i = 1; i < rows - 1; i++) {
                mazeMatrix[i][0] = 0;
                mazeMatrix[i][columns - 1] = 0;
            }
            for (int i = 1; i < rows - 1; i++) {
                String s = in.readLine();
                for (int j = 1; j < columns - 1; j++) {
                    mazeMatrix[i][j] = 1;
                    if (s.charAt(j - 1) == '*') {
                        mazeMatrix[i][j] = 0;
                    } else if (s.charAt(j - 1) == 'g') {
                        goal = new Position(i, j);
                    } else if (s.charAt(j - 1) == 's') {
                        currentP = new Position(i, j);
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }

    public boolean solve() {
        return solve(currentP);
    }

    private boolean solve(Position p) {

        mazeMatrix[p.row][p.col] = 2;

        if (p.equals(goal)) {
            return true;
        }

        if (mazeMatrix[p.row + 1][p.col] == 1) {
            if (solve(new Position(p.row + 1, p.col))) {
                return true;
            }
        }

        if (mazeMatrix[p.row - 1][p.col] == 1) {
            if (solve(new Position(p.row - 1, p.col))) {
                return true;
            }
        }

        if (mazeMatrix[p.row][p.col + 1] == 1) {
            if (solve(new Position(p.row, p.col + 1))) {
                return true;
            }
        }

        if (mazeMatrix[p.row][p.col - 1] == 1) {
            if (solve(new Position(p.row, p.col - 1))) {
                return true;
            }
        }

        mazeMatrix[p.row][p.col] = 3;
        return false;
    }

    public void print() {
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                System.out.print(mazeMatrix[i][j]);
            }
            System.out.println();
        }
    }

}

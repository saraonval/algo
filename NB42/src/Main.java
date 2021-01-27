
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Enter n (number of pairs of floats (points) between -1 and 1 for x and y): ");
        int n = scanner.nextInt();

        if (n < 2) {
            n = 2;
        }

        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            double[] point = random.doubles(2, -1, 1).toArray();
            float x = (float) point[0];
            float y = (float) point[1];
            points[i] = new Point(x, y);
        }

        System.out.println(Arrays.toString(points));

        System.out.println(minDistanceBetweenTwoPoints(points));
    }

    // returnerar det kortaste avståndet mellan två punkter
    public static float minDistanceBetweenTwoPoints(Point[] points) {

        float minDistance = Float.MAX_VALUE;
        float minLocalDistance = Float.MAX_VALUE;

        for (int i = 0; i < points.length - 1; i++) {
            Point point1 = points[i];
            Point point2 = points[i + 1];
            float x1 = point1.getX();
            float x2 = point2.getX();
            float y1 = point1.getY();
            float y2 = point2.getY();

            // Avståndsformeln
            // https://www.matteboken.se/lektioner/matte-2/geometri/avstandsformeln
            float distance = (float) Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));

            minLocalDistance = min(minLocalDistance, distance);
            minDistance = min(minLocalDistance, minDistance);
        }

        return minDistance;
    }

    private static float min(float d1, float d2) {
        if (d1 < d2) {
            return d1;
        }
        return d2;
    }

    /*
    public static float minDistance(Point[] points) {
        return minDistance(points, 0, points.length - 1);
    }

    
    public static float minDistance(Point[] points, int left, int right) {

        if (left > right) {
            return 0;
        }

        Point point1 = points[left];
        Point point2 = points[left + 1];
        float x1 = point1.getX();
        float x2 = point2.getX();
        float y1 = point1.getY();
        float y2 = point2.getY();

        // Avståndsformeln
        // https://www.matteboken.se/lektioner/matte-2/geometri/avstandsformeln
        float distance = (float) Math.sqrt(((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
        
        else if(left == right) {
            return min(0, minLeft);
        }

        int center = (left + right) / 2;
        float distance = Float.MAX_VALUE;
        float minLeft = 0;

        for (int i = center; i >= left; i--) {
            sum = sum + points[i];
            minLeft = min(minLeft, distance);
        }

        sum = 0;
        float minRight = 0;
        for (int i = center + 1; i <= right; i++) {
            sum = sum + array[i];
            maxRight = max(maxRight, sum);
        }

        int minOverCenter = minLeft + minRight;
        return min(minOverCenter, min(minDistance(points, left, center), minDistance(points, center + 1, right)));
    }
*/
    
}

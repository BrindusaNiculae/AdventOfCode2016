package day1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author brindu
 */
public class Day1 {

    static int horizontalSum;
    static int verticalSum;
    static int rotation;

    public static int computeDistance(Scanner input) throws IOException {
        String[] coordinates = input.nextLine().split(", ");

        horizontalSum = 0;
        verticalSum = 0;
        rotation = 0;

        for (String coord : coordinates) {
            if (coord.charAt(0) == 'R') {
                if (rotation % 4 == 0) {
                    verticalSum += Integer.valueOf(coord.substring(1));
                } else if (rotation % 4 == 1) {
                    horizontalSum += Integer.valueOf(coord.substring(1));
                } else if (rotation % 4 == 2) {
                    verticalSum -= Integer.valueOf(coord.substring(1));
                } else if (rotation % 4 == 3) {
                    horizontalSum -= Integer.valueOf(coord.substring(1));
                }
                rotation += 5;
            } else {
                if (rotation % 4 == 0) {
                    verticalSum -= Integer.valueOf(coord.substring(1));
                } else if (rotation % 4 == 1) {
                    horizontalSum -= Integer.valueOf(coord.substring(1));
                } else if (rotation % 4 == 2) {
                    verticalSum += Integer.valueOf(coord.substring(1));
                } else if (rotation % 4 == 3) {
                    horizontalSum += Integer.valueOf(coord.substring(1));
                }
                rotation += 3;
            }
        }
        return Math.abs(horizontalSum) + Math.abs(verticalSum);
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        System.out.println("test1: " + computeDistance(new Scanner(Day1.class.getResourceAsStream("test1"))));
        System.out.println("test2: " + computeDistance(new Scanner(Day1.class.getResourceAsStream("test2"))));
        System.out.println("test3: " + computeDistance(new Scanner(Day1.class.getResourceAsStream("test3"))));
        System.out.println("map: " + computeDistance(new Scanner(Day1.class.getResourceAsStream("map"))));

    }

}

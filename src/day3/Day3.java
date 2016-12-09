package day3;

import java.util.Scanner;

/**
 * @author brindu
 */
public class Day3 {

    public static boolean isTriangle(int a, int b, int c) {
        if ((a + b > c) && (b + c > a) && (a + c > b)) {
            return true;
        }
        return false;
    }

    public static int countTrianglesPart1(Scanner input) {
        int count = 0;
        int a, b, c;

        while (input.hasNextLine()) {
            String[] numbers = input.nextLine().split("  ");

            if (isTriangle(Integer.valueOf(numbers[0]),
                    Integer.valueOf(numbers[1]),
                    Integer.valueOf(numbers[2]))) {
                count++;
            }
        }
        return count;
    }

    public static int countTrianglesPart2(Scanner input) {
        int count = 0;

        while (input.hasNextLine()) {
            String line1 = input.nextLine();
            String[] numbers1 = line1.split("  ");

            String line2 = input.nextLine();
            String[] numbers2 = line2.split("  ");

            String line3 = input.nextLine();
            String[] numbers3 = line3.split("  ");

            if (isTriangle(
                    Integer.valueOf(numbers1[0]),
                    Integer.valueOf(numbers2[0]),
                    Integer.valueOf(numbers3[0]))) {
                count++;
            }
            if (isTriangle(
                    Integer.valueOf(numbers1[1]),
                    Integer.valueOf(numbers2[1]),
                    Integer.valueOf(numbers3[1]))) {
                count++;
            }
            if (isTriangle(
                    Integer.valueOf(numbers1[2]),
                    Integer.valueOf(numbers2[2]),
                    Integer.valueOf(numbers3[2]))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("NumTriangles Part1: " + countTrianglesPart1(new Scanner(Day3.class.getResourceAsStream("input"))));
        System.out.println("NumTriangles Part2: " + countTrianglesPart2(new Scanner(Day3.class.getResourceAsStream("input"))));
    }
}

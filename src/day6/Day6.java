package day6;

import java.util.Scanner;

/**
 *
 * @author brindu
 */
public class Day6 {

    private static String decodeMessage(Scanner scanner, boolean findMax) {
        String message = "";
        int[][] countMatrix = new int[10][30];

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                countMatrix[i][line.charAt(i) - 96] += 1;
                int index = line.charAt(i) - 96;
            }
        }

        for (int i = 0; i < countMatrix.length; i++) {
            int comparator;
            if (findMax) {
                comparator = 0;
            } else {
                comparator = 100;
            }
            int position = 0;
            for (int j = 0; j < countMatrix[i].length; j++) {
                if (findMax) {
                    if (countMatrix[i][j] > comparator) {
                        comparator = countMatrix[i][j];
                        position = j;
                    }
                } else {
                    if (countMatrix[i][j] < comparator && countMatrix[i][j] > 0) {
                        comparator = countMatrix[i][j];
                        position = j;
                    }
                }

            }
            char c = 'a';
            c += position - 1;
            message = message.concat(String.valueOf(c));
        }
        return message;
    }

    public static void main(String[] args) {
        System.out.println("Decoded example by max: " + decodeMessage(new Scanner(Day6.class.getResourceAsStream("example")), true));
        System.out.println("Decoded input by max: " + decodeMessage(new Scanner(Day6.class.getResourceAsStream("input")), true));

        System.out.println("Decoded example by min: " + decodeMessage(new Scanner(Day6.class.getResourceAsStream("example")), false));
        System.out.println("Decoded input by min: " + decodeMessage(new Scanner(Day6.class.getResourceAsStream("input")), false));

    }
}

package day4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author brindu
 */
public class Day4 {

    static Comparator<Integer> defaultComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    };

    private static char rotateChar(char currentChar, Integer sectorId) {
        if (currentChar + (sectorId % 26) > 122) {
            currentChar += 97 + (sectorId % 26) - 123;
            return currentChar;
        } else {
            currentChar += (sectorId % 26);
            return currentChar;
        }
    }

    private static HashMap<Character, Integer> splitCharsInHashMap(String chars, Boolean rotate, Integer sectorId) {
        HashMap<Character, Integer> charsMap = new HashMap<>();

        String newCode = "";
        for (int i = 0; i < chars.length(); i++) {
            char currentChar = chars.charAt(i);
            if (rotate) {
                currentChar = rotateChar(currentChar, sectorId);
                newCode = newCode.concat(String.valueOf(currentChar));
            }
            if (charsMap.containsKey(currentChar)) {
                int oldValue = charsMap.get(currentChar);
                charsMap.put(currentChar, oldValue + 1);
            } else {
                charsMap.put(currentChar, 1);
            }
        }
        if (newCode.contains("north") && newCode.contains("pole") && newCode.contains("objects")) {
            System.out.println("NewCode: " + newCode + " from room: " + sectorId);
        }
        return charsMap;
    }

    private static List<Integer> orderValuesDescending(HashMap<Character, Integer> charsMap) {
        List<Integer> values = new ArrayList();
        values.addAll(charsMap.values());
        values.sort(defaultComparator);
        return values;
    }

    private static boolean isRealRoom(String checksum, HashMap<Character, Integer> charsInMap, List<Integer> orderedValues) {
        for (int i = 0; i < checksum.length(); i++) {
            Character currentChar = checksum.charAt(i);
            if (!charsInMap.containsKey(currentChar)) {
                return false;
            }
            if (!charsInMap.get(currentChar).equals(orderedValues.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static int computeSum(Scanner input, Boolean rotate) {
        int sum = 0;
        while (input.hasNext()) {

            String[] line = input.nextLine().split("\\[");

            String checksum = line[1].substring(0, line[1].length() - 1);
            Integer sectorId = Integer.valueOf(line[0].substring(line[0].lastIndexOf("-") + 1, line[0].length()));
            String chars = line[0].substring(0, line[0].lastIndexOf("-")).replace("-", "");

            HashMap<Character, Integer> charsMap = splitCharsInHashMap(chars, rotate, sectorId);
            List<Integer> orderedValues = orderValuesDescending(charsMap);

            if (isRealRoom(checksum, charsMap, orderedValues)) {
                sum += sectorId;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Sum of sector IDs of the real rooms in example: " + computeSum(new Scanner(Day4.class.getResourceAsStream("example")), false));
        System.out.println("Sum of sector IDs of the real rooms in input: " + computeSum(new Scanner(Day4.class.getResourceAsStream("input")), false));

        System.out.println("Sum of sector IDs of the real rooms in example, rotation on: " + computeSum(new Scanner(Day4.class.getResourceAsStream("example")), true));
        System.out.println("Sum of sector IDs of the real rooms in example-rotation, rotation on: " + computeSum(new Scanner(Day4.class.getResourceAsStream("example-rotation")), true));
        System.out.println("Sum of sector IDs of the real rooms in input, rotation on: " + computeSum(new Scanner(Day4.class.getResourceAsStream("input")), true));

    }
}

package day2;

import java.util.Scanner;

/**
 *
 * @author brindu
 */
public class Day2 {

    public static String getNumberFromCoordsPart1(String coords) {
        if (coords.equals("00")) {
            return "1";
        }
        if (coords.equals("01")) {
            return "2";
        }
        if (coords.equals("02")) {
            return "3";
        }
        if (coords.equals("10")) {
            return "4";
        }
        if (coords.equals("11")) {
            return "5";
        }
        if (coords.equals("12")) {
            return "6";
        }
        if (coords.equals("20")) {
            return "7";
        }
        if (coords.equals("21")) {
            return "8";
        }
        if (coords.equals("22")) {
            return "9";
        }
        return "";
    }

    public static String getNumberFromCoordsPart2(String coords) {
        if (coords.equals("02")) {
            return "1";
        }
        if (coords.equals("11")) {
            return "2";
        }
        if (coords.equals("12")) {
            return "3";
        }
        if (coords.equals("13")) {
            return "4";
        }
        if (coords.equals("20")) {
            return "5";
        }
        if (coords.equals("21")) {
            return "6";
        }
        if (coords.equals("22")) {
            return "7";
        }
        if (coords.equals("23")) {
            return "8";
        }
        if (coords.equals("24")) {
            return "9";
        }
        if (coords.equals("31")) {
            return "A";
        }
        if (coords.equals("32")) {
            return "B";
        }
        if (coords.equals("33")) {
            return "C";
        }
        if (coords.equals("42")) {
            return "D";
        }
        return "";
    }

    public static String computeCodePart1(Scanner input) {
        String code = "";
        int currentLine = 1;
        int currentColumn = 1;
        int newLine, newColumn;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case 'U':
                        newLine = currentLine - 1;
                        if (newLine >= 0) {
                            currentLine = newLine;
                        }
                        break;
                    case 'D':
                        newLine = currentLine + 1;
                        if (newLine <= 2) {
                            currentLine = newLine;
                        }
                        break;
                    case 'R':
                        newColumn = currentColumn + 1;
                        if (newColumn <= 2) {
                            currentColumn = newColumn;
                        }
                        break;
                    case 'L':
                        newColumn = currentColumn - 1;
                        if (newColumn >= 0) {
                            currentColumn = newColumn;
                        }
                        break;
                }
            }
            code = code.concat(getNumberFromCoordsPart1(String.valueOf(currentLine) + String.valueOf(currentColumn)));
        }
        return code;
    }

    public static String computeCodePart2(Scanner input) {
        String code = "";
        int currentLine = 2;
        int currentColumn = 0;
        int newLine, newColumn;

        while (input.hasNextLine()) {
            String line = input.nextLine();
            for (int i = 0; i < line.length(); i++) {
                switch (line.charAt(i)) {
                    case 'U':
                        newLine = currentLine - 1;
                        if (newLine == 1 || newLine == 3) {
                            if (currentColumn >= 1 && currentColumn <= 3) {
                                currentLine = newLine;
                            }

                        } else if (newLine == 0 || newLine == 4) {
                            if (currentColumn == 2) {
                                currentLine = newLine;
                            }
                        } else if (newLine == 2) {
                            currentLine = newLine;
                        }
                        break;
                    case 'D':
                        newLine = currentLine + 1;
                        if (newLine == 1 || newLine == 3) {
                            if (currentColumn >= 1 && currentColumn <= 3) {
                                currentLine = newLine;
                            }

                        } else if (newLine == 0 || newLine == 4) {
                            if (currentColumn == 2) {
                                currentLine = newLine;
                            }
                        } else if (newLine == 2) {
                            currentLine = newLine;
                        }
                        break;
                    case 'R':
                        newColumn = currentColumn + 1;
                        if (newColumn == 1 || newColumn == 3) {
                            if (currentLine >= 1 && currentLine <= 3) {
                                currentColumn = newColumn;
                            }
                        } else if (newColumn == 0 || newColumn == 4) {
                            if (currentLine == 2) {
                                currentColumn = newColumn;
                            }
                        } else if (newColumn == 2) {
                            currentColumn = newColumn;
                        }
                        break;
                    case 'L':
                        newColumn = currentColumn - 1;
                        if (newColumn == 1 || newColumn == 3) {
                            if (currentLine >= 1 && currentLine <= 3) {
                                currentColumn = newColumn;
                            }
                        } else if (newColumn == 0 || newColumn == 4) {
                            if (currentLine == 2) {
                                currentColumn = newColumn;
                            }
                        } else if (newColumn == 2) {
                            currentColumn = newColumn;
                        }
                        break;
                }
            }
            code = code.concat(getNumberFromCoordsPart2(String.valueOf(currentLine) + String.valueOf(currentColumn)));
        }
        return code;
    }

    public static void main(String[] args) {
        System.out.println("Part1 example: " + computeCodePart1(new Scanner(Day2.class.getResourceAsStream("example"))));
        System.out.println("Part1 input: " + computeCodePart1(new Scanner(Day2.class.getResourceAsStream("input"))));
        System.out.println("Part2 example: " + computeCodePart2(new Scanner(Day2.class.getResourceAsStream("example"))));
        System.out.println("Part2 input: " + computeCodePart2(new Scanner(Day2.class.getResourceAsStream("input"))));

    }
}

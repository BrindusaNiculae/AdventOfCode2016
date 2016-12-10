package day5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author brindu
 */
public class Day5 {

    private static String toHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(0xFF & bytes[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    private static String computePassword(String input) throws NoSuchAlgorithmException {
        String password = "";
        int currentLengthOfPass = 0;
        int n = 0;
        String correctStart = "00000";
        String partialHash;
        MessageDigest messageDigest;

        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update((input + n).getBytes());
        partialHash = toHexString(messageDigest.digest());
        while (currentLengthOfPass < 8) {

            while (!partialHash.startsWith(correctStart)) {
                n++;
                messageDigest.reset();
                messageDigest.update((input + n).getBytes());
                partialHash = toHexString(messageDigest.digest());
            }
            System.out.println("partialHash: " + partialHash + " at n: " + n);
            password = password.concat(String.valueOf(partialHash.charAt(5)));
            currentLengthOfPass++;
            partialHash = "";
        }
        return password;
    }

    private static String computePasswordPart2(String input) throws NoSuchAlgorithmException {
        String password = "xxxxxxxx";
        int currentNumCharsOfPass = 0;
        int n = 0;
        int index;
        String correctStart = "00000";
        String partialHash;
        MessageDigest messageDigest;

        messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update((input + n).getBytes());
        partialHash = toHexString(messageDigest.digest());
        while (currentNumCharsOfPass < 8) {

            while (!partialHash.startsWith(correctStart)) {
                n++;
                messageDigest.reset();
                messageDigest.update((input + n).getBytes());
                partialHash = toHexString(messageDigest.digest());
            }
            index = partialHash.charAt(5) - '0';
            System.out.println("partialHash: " + partialHash
                    + " at n: " + n
                    + " index: " + index
                    + " new char: " + partialHash.charAt(6)
                    + " pass: " + password);

            if (index < 8 && password.charAt(index) == 'x') {
                password = password.substring(0, index)
                        + partialHash.charAt(6)
                        + password.substring(index + 1, 8);
                currentNumCharsOfPass++;
            }
            partialHash = "";
        }
        return password;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Pass for 'abc': " + computePassword("abc"));
        System.out.println("Pass for 'ffykfhsq': " + computePassword("ffykfhsq"));
        System.out.println("Pass for 'abc' part2: " + computePasswordPart2("abc"));
        System.out.println("Pass for 'ffykfhsq' part2: " + computePasswordPart2("ffykfhsq"));
    }
}

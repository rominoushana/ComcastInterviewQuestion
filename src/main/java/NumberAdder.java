import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.google.common.base.CharMatcher;

import java.nio.file.Paths;
import java.util.Scanner;

import static java.nio.file.Files.readAllBytes;

/**
 * Created by rominoushana on 10/13/18.
 */
public class NumberAdder {

    @Parameter(names = {"-f"})
    static boolean file = false;
    @Parameter(names = {"-x"})
    static boolean hex = false;

    public static long addNumbers(String input, boolean includeLetters) throws Exception {

        // Remove all white space from string
        input = input.replaceAll("\\s+", "");

        // If -x is not included, we will strip all the non digit characters from the string
        if (!includeLetters) {
            input = CharMatcher.inRange('0', '9').retainFrom(input);
        }

        // This will be the final sum of the character values from the string
        long sum = 0;

        // Iterate through the string character by character until the end of string
        for (int i = 0; i < input.length(); i++) {

            // Current character of string
            char c = input.charAt(i);
            int value = 0;

            // If character is not a digit, we will convert the character into its hexdecimal value
            if (!Character.isDigit(c)) {
                value = convertCharacterToHexValue(c);
            } else {
                value = Character.getNumericValue(c);
            }

            // Add the value to the total sum
            sum += value;
        }
        return sum;
    }

    public static int convertCharacterToHexValue(char unconvertedCharacter) throws Exception {

        try {
            return Integer.parseInt(Character.toString(unconvertedCharacter), 16);
        } catch (NumberFormatException e) {
            throw new Exception("Sorry your input was invalid. '" + unconvertedCharacter + "' is not a valid Hex character. Cannot convert into integer value.");
        }
    }

    public static void main(String[] args) throws Exception {
        NumberAdder numberAdder = new NumberAdder();
        JCommander.newBuilder()
                .addObject(numberAdder)
                .build()
                .parse(args);

        String input;

        // Reading STDIN
        Scanner scanner = new Scanner(System.in);

        // If the file flag is true, program will read the file path so that the input will be from the provided file
        if (file) {
            System.out.println("Please enter your file path: ");
            String filePath = scanner.nextLine();
            input = new String(readAllBytes(Paths.get(filePath)));

        } else {
            System.out.print("Please enter your string: ");
            input = scanner.nextLine();
        }

        System.out.println(addNumbers(input, hex));
    }
}

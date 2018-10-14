import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Created by rominoushana on 10/13/18.
 */
public class NumberAdderTest {

    @DisplayName("Valid Hex to Decimal Converter")
    @Test
    void convertHexCharacterToIntegerValue() throws Exception {
        Character c = 'a';
        int expected = 10;
        Assertions.assertEquals(expected, NumberAdder.convertCharacterToHexValue(c));
    }

    @DisplayName("Invalid Hex to Decimal Converter")
    @Test
    void convertInvalidHexCharacterToIntegerValue() throws Exception {
        Character c = 'g';
        Assertions.assertThrows(Exception.class, () -> NumberAdder.convertCharacterToHexValue(c));
    }

    @DisplayName("Add Numbers with no input")
    @Test
    void addNumbersWithNoInput() throws Exception {
        String input = "";
        long expected = 0;
        Assertions.assertEquals(expected, NumberAdder.addNumbers(input, false));
    }

    @DisplayName("Add Numbers with spaces in input")
    @Test
    void addNumbersWithSpacesInInput() throws Exception {
        String input = "a  b   c 1 3  2";
        long expected = 6;
        Assertions.assertEquals(expected, NumberAdder.addNumbers(input, false));
    }

    @DisplayName("Add Numbers with Hex flag")
    @Test
    void addNumbersWithHexTest() throws Exception {
        String input = "aaace21";
        long expected = 59;
        Assertions.assertEquals(expected, NumberAdder.addNumbers(input, true));
    }

    @DisplayName("Add Numbers without Hex flag")
    @Test
    void addNumbersWithoutHexTest() throws Exception {
        String input = "aaace21";
        long expected = 3;
        Assertions.assertEquals(expected, NumberAdder.addNumbers(input, false));
    }

}

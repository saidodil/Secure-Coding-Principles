import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for PartOne.java program.
 *
 * @author Dilnoza Saidova
 * @version 8 August 2022
 */
class PartOneTest {

    @org.junit.jupiter.api.Test
    void getName() {
        String param = "first";
        String input = "Dilnoza";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("Dilnoza", PartOne.getName(param));

        param = "last";
        input = "Dilnoza";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertNotEquals("Saidova", PartOne.getName(param));
    }

    @org.junit.jupiter.api.Test
    void validName() {
        String param = "Dilnoza";
        assertTrue(PartOne.validName(param));

        param = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
        assertFalse(PartOne.validName(param));

        param = "";
        assertFalse(PartOne.validName(param));

        param = "Dilnoza!!";
        assertFalse(PartOne.validName(param));
    }

    @Test
    void getInt() {
        String param = "first";
        int input = 1;
        String s = String.valueOf(input);
        InputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        assertEquals(1, PartOne.getInt(param));

        param = "last";
        input = 5;
        s = String.valueOf(input);
        in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        assertEquals(5, PartOne.getInt(param));

        param = "last";
        input = 50;
        s = String.valueOf(input);
        in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        assertNotEquals(5, PartOne.getInt(param));
    }

    @org.junit.jupiter.api.Test
    void getFileName() {
        String param = "input";
        String input = "input.txt";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("input.txt", PartOne.getFileName(param));

        param = "output";
        input = "output.txt";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("output.txt", PartOne.getFileName(param));
    }

    @org.junit.jupiter.api.Test
    void getPassword() {
        String param = "Please enter password:";
        String input = "1!uooxzHHHHH";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertEquals("1!uooxzHHHHH", PartOne.getPassword(param));
    }

    @org.junit.jupiter.api.Test
    void hashPassword() {
        String password = "1!uooxzHHHHH";
        String hash = "954a8f6d9d24faeecacf65e6c408ea5b506d3a281cef0730db28cc580c15c8b4";
        assertEquals(hash, PartOne.hashPassword(password));
        password += "abc";
        assertNotEquals(hash, PartOne.hashPassword(password));
    }

    @org.junit.jupiter.api.Test
    void validPassword() {
        String password = "1!uooxzHHHHH";
        assertTrue(PartOne.validPassword(password));

        password = "12345abc"; //no special characters
        assertFalse(PartOne.validPassword(password));

        password = "abcdefg#$%"; //no integers
        assertFalse(PartOne.validPassword(password));

        password = "12345678****"; //no letters
        assertFalse(PartOne.validPassword(password));

        password = "1!abc"; //less than 8 characters
        assertFalse(PartOne.validPassword(password));

        password = "12345$&()abcdefg"; //over 15 characters
        assertFalse(PartOne.validPassword(password));

        password = ""; //null
        assertFalse(PartOne.validPassword(password));
    }

    @org.junit.jupiter.api.Test
    void writeToFile() {
        String inputFileName = "input.txt";
        File inputFile = new File(inputFileName);
        assertTrue(PartOne.writeToFile("Dilnoza", "Saidova", 1, 2, inputFileName, "output", inputFile));

        inputFile = new File("input");
        assertFalse(PartOne.writeToFile("Dilnoza", "Saidova", 1, 2, inputFileName, "output", inputFile));
    }
}
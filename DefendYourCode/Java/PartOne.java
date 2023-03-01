/*
 * Course: TCSS483 – Secure Coding Principles
 * File Name: PartOne.java
 * Assignment: Defend Your Code!
 * Due Date: 8 August 2022
 * Instructor: Tom Capaul
 */
import java.io.File;
import java.io.FileWriter;
import java.security.MessageDigest;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given program gets validated information from user
 * and stores it in output file.
 *
 * @author Abdulrehim Shuba
 * @author Dilnoza Saidova
 * @author Gil Rabara
 * @version 7 August 2022
 */
public class PartOne {

    public static void main(String[] theArgs) {
        String firstName, lastName, inputFileName, outputFileName, password,
               verifyPassword, passwordHash1, passwordHash2;
        int firstInt, secondInt;
        firstName = getName("first");
        lastName = getName("last");
        firstInt = getInt("first");
        secondInt = getInt("last");
        inputFileName = getFileName("input");
        outputFileName = getFileName("output");
        password = getPassword("Enter your password (include 8 to"
                               + " 20 characters: at least 1 uppercase and"
                               + " lowercase letter, digit, special character):");
        passwordHash1 = hashPassword(password);
        File inputFile = new File(inputFileName);

        // open and write  hashed password to input file
        try {
            inputFile.createNewFile();
            FileWriter fw = new FileWriter(inputFileName);
            fw.write(passwordHash1);
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing password to file!");
        }
        verifyPassword = getPassword("Re-Enter your password: ");
        passwordHash2 = hashPassword(verifyPassword);

        // read hash password from input file
        String data = "";
        try {
            Scanner myReader = new Scanner(inputFile);
            data = myReader.nextLine();
            myReader.close();
        } catch (Exception e) {
            System.out.println("Error reading password from file!");
        }

        while (!data.equals(passwordHash2)) {
            System.out.println("Password is incorrect!");
            verifyPassword = getPassword("Re-Enter your password: ");
            passwordHash2 = hashPassword(verifyPassword);
        }

        writeToFile(firstName, lastName, firstInt, secondInt, inputFileName,
                    outputFileName, inputFile);
    }

    /**
     * Prompts for user's name and validates the input.
     *
     * @param theName type of name to validate.
     * @return String validated user's name
     */
    public static String getName(final String theName) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your " + theName + " name:");
        String name = input.nextLine();
        while (!validName(name)) {
            System.out.println("Enter valid name in expected format -"
                               + " start with uppercase: ");
            System.out.println("Enter your " + theName + " name:");
            name = input.nextLine();
        }
        return name;
    }

    /**
     * Returns validity of the user's name.
     *
     * @param theName user's name to validate.
     * @return boolean whether user's name is valid.
     */
    public static boolean validName(final String theName) {
        return theName.length() <= 50
               && theName.matches("[A-Z][a-z]*")
               && theName.length() != 0;
    }

    /**
     * Returns valid integer value.
     *
     * @param theNum type of integer to validate.
     * @return int validated integer value.
     */
    public static int getInt(final String theNum) {
        int result;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your " + theNum + " integer value: ");
        try {
            result = Integer.parseInt(input.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid integer! Please try again.");
            result = getInt(theNum);
        }
        return result;
    }

    /**
     * Prompts for file name until input is valid.
     *
     * @param theFile file name
     * @return String validated file name
     */
    public static String getFileName(final String theFile) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter " + theFile + " file as format of"
                           + " 'filename.txt', containing 5 or more characters:");
        String line = input.nextLine();
        while (line.length() < 5 || !line.endsWith(".txt")) {
            if (line.length() < 5) {
                System.out.println("You entered file name incorrectly!");
                System.out.println("Enter " + theFile
                                   + " file name in 'filename.txt' format:");
            } else {
                System.out.println("File name should only be in 'filename.txt' format!");
                System.out.println("Enter " + theFile
                                   + " file in 'filename.txt' format"
                                   + " with .txt extension:");
            }
            line = input.nextLine();
        }
        return line;
    }

    /**
     * Prompts for password until its format is correct.
     *
     * @param thePassword password to accept from user.
     * @return String validated password
     */
    public static String getPassword(final String thePassword) {
        Scanner input = new Scanner(System.in);
        System.out.println(thePassword);
        String password = input.nextLine();
        while (!validPassword(password)) {
            System.out.println("Please enter password in correct format:");
            password = input.nextLine();
        }
        return password;
    }

    /**
     * Hashes the given password.
     *
     * @param thePassword user's password
     * @return String hash of password
     */
    public static String hashPassword(final String thePassword) {
        String hash = "";
        StringBuilder sb;
        byte[] salt = {(byte) 0xA9, (byte) 0x9B, (byte) 0xC8, (byte) 0x32,
                       (byte) 0x56, (byte) 0x35, (byte) 0xE3, (byte) 0x03};
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedPassword = md.digest(thePassword.getBytes());
            sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            hash = sb.toString();
        } catch (Exception e) {
            System.out.println("Error hashing thePassword.");
        }
        return hash;
    }

    /**
     * Validates password based on regular expression:
     * Must have at least one numeric character
     * Must have at least one lowercase character
     * Must have at least one uppercase character
     * Must have at least one special symbol among @#$%
     * Password length should be between 8 and 20
     *
     * @param thePassword password
     * @return boolean whether password is valid
     */
    public static boolean validPassword(final String thePassword) {
        if (thePassword == null) {
            return false;
        }
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])" +
                       "(?=.*[ !@#$%&*()-+=^]).{8,15}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(thePassword);
        return m.matches();
    }

    /**
     * Returns whether reading from input file and writing
     * to output file were successfully completed.
     *
     * @param theFirstName user's first name
     * @param theLastName user's last name
     * @param theFirstInt first integer value
     * @param theSecondInt second integer value
     * @param theInputFileName name of input file
     * @param theOutputFileName name of output file
     * @param theInputFile input file
     * @return boolean success of file reading and writing.
     */
    public static boolean writeToFile(final String theFirstName, final String theLastName,
                                   final int theFirstInt, final int theSecondInt,
                                   final String theInputFileName,
                                   final String theOutputFileName,
                                   final File theInputFile) {
        boolean success = false;
        // Open the output file in write mode
        FileWriter fw = null;
        Scanner input = null;
        try {
            fw = new FileWriter(theOutputFileName);
            fw.write("First name: " + theFirstName + "\n");
            fw.write("Last name: " + theLastName + "\n");
            fw.write("First integer: " + theFirstInt + "\n");
            fw.write("Second integer: " + theSecondInt + "\n");
            fw.write("Sum: " + ((long) theFirstInt + (long) theSecondInt) + "\n");
            fw.write("Product: " + ((long) theFirstInt * (long) theSecondInt) + "\n");
            fw.write("Input file: " + theInputFileName + "\n");
            fw.write("Input file contents:\n");
            // Read the contents of the input file and write it to the output file
            try {
                input = new Scanner(theInputFile);
                while (input.hasNextLine()) {
                    fw.write(input.nextLine() + "\n");
                }
                success = true;
                input.close();
            } catch (Exception e) {
                System.out.println("Error reading input file: " + e);
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing to file: " + e);
        }
        return success;
    }
}
/*
 * Course: TCSS483 Secure Coding Principles
 * File Name: IndividualAssign.java
 * Assignment: Individual Assignment
 * Due Date: 15 July 2022
 * Instructor: Tom Capaul
 */
import java.util.Scanner;

/**
 * Regular expressions - validates input based on a criteria of
 * a chosen option from welcoming menu.
 *
 * @author Dilnoza Saidova
 * @version 15 July 2022
 */
public class IndividualAssign {
    public static void main(String[] theArgs) {
        final Scanner console = new Scanner(System.in);
        System.out.println("-*-*-*- Please choose one of the options: -*-*-*-");
        System.out.println("a. Social Security Number");
        System.out.println("b. US Phone Number");
        System.out.println("c. E-mail address");
        System.out.println("d. Name on a class roster (Last, First, MI)");
        System.out.println("e. Date in MM/DD/YYYY format");
//        System.out.println("f. House address - Street number, street name, abbreviation "
//                           + "for road, street, boulevard or avenue");
        System.out.println("g. City, State Zip (or City, State, Zip)");
        System.out.println("h. Military time, including seconds");
        System.out.println("i. US Currency down to the penny (ex: $123,456,789.01)");
        System.out.println("j. URL - http:// optional");
        System.out.println("k. Password - at least 10 characters, 1 upper case character," +
                " 1 lower case character, digit, punctuation mark");
        System.out.println("l. Word containing an odd number of alphabetic " +
                "characters, ending in 'ion'");
        System.out.println("q. Quit");

        inputGenerator(console);
        console.close();
    }

    /**
     * Generates input
     * @param theInput user input
     */
    private static void inputGenerator(Scanner theInput) {
        String choice = "";
        String input = "";
        do {
            System.out.println("Enter your option: ");
            choice = theInput.nextLine().toLowerCase();
            if (choice.equalsIgnoreCase("q")) {
                return;
            }
            System.out.println("Enter your string: ");
            input = theInput.nextLine();

            switch (choice.charAt(0)) {
                case 'a':
                    if (checkSSN(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'b':
                    if (checkPhone(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'c':
                    if (checkEmail(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'd':
                    if (checkName(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'e':
                    if (checkDate(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
//                case 'f':
//                    if(checkAddress(str)) {
//                        System.out.println("Valid String!");
//                    } else {
//                        System.out.println("Invalid String!");
//                    }
//                    break;
                case 'g':
                    if (checkCity(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'h':
                    if (checkTime(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'i':
                    if (checkMoney(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'j':
                    if (checkURL(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'k':
                    if (checkPassword(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                case 'l':
                    if (checkIon(input)) {
                        System.out.println("Valid String!");
                    } else {
                        System.out.println("Invalid String!");
                    }
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        } while (!choice.equalsIgnoreCase("q"));
    }

    /**
     * Validates social security number
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkSSN(String theStr) {
        if(theStr.matches("^(\\d{3}-\\d{2}-\\d{4})|(\\d{3}\\d{2}\\d{4})"
                          + "|(\\d{3}\\s\\d{2}\\s\\d{4})$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates US phone number.
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkPhone(String theStr) {
        if(theStr.matches("^\\(?(\\d{3})\\)?[-. ]?(\\d{3})[-. ]?(\\d{4})$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates email address
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkEmail(String theStr) {
        if(theStr.matches("[a-z\\d]+@[a-z]+\\.[a-z]{2,3}")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates first, last, middle initial name
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkName(String theStr) {
        if(theStr.matches("^[a-zA-Z]+(([',.\\-][a-zA-Z, ])?[a-zA-Z])*$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates date (MM/DD/YYYY)
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkDate(String theStr) {
        if(theStr.matches("^(1[0-2]|0[1-9])/(3[01]|[12]\\d|0[1-9])/\\d{4}$")) {
            return true;
        } else {
            return false;
        }
    }

//    public static boolean checkAddress(String theStr) {
//        if(theStr.matches("^(\\\\d{1,}) [a-zA-Z0-9\\\\s]")) {
//            return true;
//        } else {
//            return false;
//        }
//    }

    /**
     * Validates city, state and zip address
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkCity(String theStr) {
        if(theStr.matches("^(.+)[,\\\\s]+(.+)\\s+(\\d{5})?$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates military time (seconds inclusive)
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkTime(String theStr) {
        if(theStr.matches("^(?:(?:([01]?\\d|2[0-3]):)?([0-5]?\\d):)?([0-5]?\\d)$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates US currency
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkMoney(String theStr) {
        if(theStr.matches("^\\$(0|[1-9]\\d{0,2})(,\\d{3})*(\\.\\d{1,2})?$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates URL
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkURL(String theStr) {
        if(theStr.matches("^\\s*(http\\:\\/\\/)?([a-z\\d\\-]{1,63}\\.)*[a-z\\d\\-]"
                          + "{1,255}\\.[a-z]{2,6}\\s*$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates password
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkPassword(String theStr) {
        if(theStr.matches("^(?=.*\\d)"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^,.?!&+=])"
                + "(?=\\S+$).{10,20}$")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Validates ending with 'ion'
     * @param theStr entered string
     * @return boolean input validity
     */
    public static boolean checkIon(String theStr) {
        if(theStr.matches("^([a-zA-Z]*)[iI][oO][nN]$")
                && theStr.length() % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
}
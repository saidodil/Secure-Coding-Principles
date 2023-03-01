/*
 * Course: TCSS483 Secure Coding Principles
 * File Name: Quine.java
 * Assignment: Self-reproducing program
 * Due Date: 29 June 2022
 * Instructor: Tom Capaul
 */

/**
 * Self-replicating program that produces the original source code as output.
 *
 * @author Dilnoza Saidova
 * @author Gil Rabara
 * @author Abdulrehim Shuba
 * @version 29 June 2022
 */
public class SelfReplicatingProgram {
    private static final char quote = 34;
    private static final String[] str = {
        "public class SelfReplicatingProgram {",
        "    private static final char quote = 34;",
        "    private static final String[] str = {",
        "        ",
        "    };",
        "    public static void main(String[] theArgs) {",
        "        //Prints class header and fields.",
        "        for(int i = 0; i < 3; i++) {",
        "            System.out.println(str[i]);",
        "        }",
        "        //Prints contents of String array.",
        "        for(String s : str) {",
        "            System.out.println(str[3] + quote + s + quote + ',');",
        "        }",
        "        //Prints contents of main-method.",
        "        for(int i = 4; i < str.length; i++) {",
        "            System.out.println(str[i]);",
        "        }",
        "    }",
        "}",
    };
    public static void main(String[] theArgs) {
        //Prints class header and fields.
        for(int i = 0; i < 3; i++) {
            System.out.println(str[i]);
        }
        //Prints contents of String array.
        for(String s : str) {
            System.out.println(str[3] + quote + s + quote + ',');
        }
        //Prints contents of main-method.
        for(int i = 4; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}

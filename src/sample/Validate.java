package sample; /**
 * Object Orientated Principles
 *
 * Project
 *
 * Name:       Steve Walsh
 * Student No: R00151053
 * Date      : 5/12/17
 *
 * validation class to help ensure only valid input is entered by user
 *
 */

import java.util.Scanner;

public class Validate {


    final  static Scanner kb = new Scanner(System.in);   // allow for keyboard input


    // validation messages
    final  static String INVALID_INTEGER = "Invalid input. Enter an integer: "                          ;
    final  static String INVALID_RANGE   = "Invalid input. Enter an option within the range provided :" ;
    final  static String INVALID_STRING  = "Invalid input. String cannot be empty: "                    ;
    final  static String INVALID_BOOLEAN = "Invalid input. Must enter a Boolean Value "                 ;
    final  static String INVALID_DOUBLE  = "Invalid input. Enter a double: "                            ;


      /*
      ---------------------------------------------------------------
             Validate input
      ---------------------------------------------------------------
       */

    /**
     * Asks question, reads and returns integer for list choices
     *
     * @param question - question asked
     * @return choice - option user picked
     */
    public  static int readInt(String question, int noOptions) {
        int choice=0;
        int input;

        System.out.println(question);
        while (!kb.hasNextInt()) {                          // checks input is an integer
            kb.nextLine();
            System.out.println(INVALID_INTEGER + "\n");     // prints error message if input is not an int
            System.out.println(question);
        }
        input = kb.nextInt();                               // if integer stores as input
        kb.nextLine();

        if (input > noOptions || input < 1) {               // checks input is in valid range
            System.out.println(INVALID_RANGE + "\n");       // prints error message if inputted int is not in range 1-6
            System.out.println(question);                   // prints out the question again
        } else {
            choice = input;                                 // if valid stores as choice
        }
        return choice;                                      // returns choice
    }

    /**
     * Reads an integer value from the console window
     *
     * @param question,
     *            question to be asked of the user
     * @return An integer value is returned.
     */
    public static  int readInt(String question) {
        int choice;
        System.out.print(question);
        while (!kb.hasNextInt()) {                          // checks input is an integer
            kb.nextLine();
            System.out.println(INVALID_INTEGER);            // prints error message if input is not an int
            System.out.println(question);
        }
        choice = kb.nextInt();                              // if integer stores as input
        kb.nextLine();

        return choice;                                      // returns choice
    }


    /**
     * Reads an double value from the console window
     *
     * @param question - question to be asked of the user
     * @return An double value is returned.
     */
    public static double readDouble(String question) {
        double choice;
        System.out.print(question);
        while (!kb.hasNextDouble()) {
            kb.nextLine();
            System.out.println(INVALID_DOUBLE);
            System.out.println(question);
        }
        choice = kb.nextDouble();
        kb.nextLine();

        return choice;
    }




    /**
     * Reads a string  value from the console window
     *
     * @param question - question to be asked of the user
     * @return choice -  string  value is returned.
     */
    public static  String readString(String question) {
        String choice;
        System.out.print(question);
        while (!kb.hasNextLine()) {
            kb.nextLine();
            System.out.println(INVALID_STRING);
            System.out.println(question);
        }
        choice = kb.nextLine();


        return choice;
    }

    /**
     * Reads a Y/N value from console
     *
     * asks a y/n  question, validates the answer and returns the boolean equivalent
     *
     * Where Y/y = true & N/n = false
     *
     * @param question - question to be asked of the user
     * @return choice -  boolean  value is returned.
     */
    public static boolean readBoolean(String question) {
        Boolean choice = null;
        boolean res = false;
        String input="";
        System.out.print(question);
        input = kb.nextLine();

        while (!res) {

            if(input.equals("y") || input.equals("Y") ) {

                choice = true;
                // breaks loop as valid input
                res = true;
                break;
            }
            else if( (input.equals("n")) || (input.equals("N"))) {

                choice = false;
                // breaks loop as valid input
                res = true;
            }
            else {
                kb.nextLine();
                System.out.println(INVALID_BOOLEAN);
                System.out.println(question);
            }
        }
        return choice;
    }

}

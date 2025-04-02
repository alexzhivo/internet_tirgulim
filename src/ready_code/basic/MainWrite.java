package ready_code.basic;

import java.io.*;
import java.util.Scanner;

/**
 * read integers from console on a single line and write them to a file
 */
public class MainWrite {

    /**
     * read integers from console on a single line and write them to a file
     * just a basic (non OOP) solution
     * @param args the file name
     */
    public static void main(String[] args) {

        // checks if there are no arguments when running the program
        if (args.length < 1) {
            System.out.println("missing input file name."); // output to console
            System.exit(0); // terminates the JVM (Java Virtual Machine)
        }

        String fileName = args[0];  // gets the first argument and saves it in String Variable

        // Using Try & Catch block for handling exceptions
        try (
                // inside the "()" write code for activating the automatic close() for resources
                Scanner scan = new Scanner(System.in);
                DataOutputStream output = new DataOutputStream (new FileOutputStream(fileName));
        ) {
            // here is the code we are trying to catch errors in...
            System.out.println("Enter numbers separated by spaces:"); // outputs text to console
            String l = scan.nextLine(); // get whole line of user input from console and saves it in 'l'
            scan.close(); // close the Scanner object
            String[] words = l.split(" ");  // splits the string into an array of strings by " "
            for (String item : words)   // loops through each string item inside the string array
                output.writeInt(Integer.parseInt(item));    // outputs to console each item as an integer.
        }
        // here we catch all the exceptions that can be thrown from previous block
        catch (NumberFormatException e) {
            System.out.println("Illegal input: " + e.getMessage());
        }
        catch (FileNotFoundException | SecurityException se) {
            System.out.println("File cannot be created: " + se.getMessage());
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Done");
        }
    }
}

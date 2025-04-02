package ready_code.basic;

import java.io.*;

/**
 * read a binary file containing integers and print them out
 * just a basic (non OOP) solution
 */
public class MainRead {

    /**
     * read a binary file containing integers and print them out
     * @param args
     */
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("missing input file name.");
            System.exit(0);
        }

        String fileName = args[0];

        // read the file - use try-with-resources
        try (DataInputStream input = new DataInputStream( new FileInputStream(fileName))) {
            // read the file and print
            System.out.println ("reading the file:");
            while (input.available() > 0)
                System.out.println(input.readInt());
        }
        catch (FileNotFoundException fnf) {
            System.out.println("File not found");
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("I/O error, reading interrupted!");
        }
    }
}

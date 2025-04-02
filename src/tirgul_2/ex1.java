package tirgul_2;

import java.io.*;
import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {

        // check if argument length is correct (needs to be only 1)
        if (args.length != 1) {
            System.out.println("Usage: java ex1 <filename>");
            System.exit(0);
        }

        // needs to create a file with the filename given from args
        String filename = args[0]; // gets the name of the file

        try (
            Scanner scan = new Scanner(System.in);
            DataOutputStream outputFile = new DataOutputStream(new FileOutputStream(filename));
        ) {
            System.out.println("Enter numbers separated by a space :");

            String line = scan.nextLine();
            scan.close();   // better close right after finish

            String [] numbers = line.split(" ");
            for (String num : numbers) {
                outputFile.writeInt(Integer.parseInt(num));
            }
            System.out.println(filename + " created successfully!");
        } catch (IOException e) {
            System.err.println("error : " + e.getMessage());
        } finally {
            System.exit(0);
        }
    }
}
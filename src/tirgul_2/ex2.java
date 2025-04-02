package tirgul_2;

import java.io.*;

public class ex2 {
    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage : java ex2 <filename>");
            System.exit(0);
        }

        String filename = args[0];

        try (DataInputStream inputFile = new DataInputStream( new FileInputStream(filename)))
        {
            while (inputFile.available() > 0) {
                System.out.println(inputFile.readInt());
            }
        } catch (Exception err) {
            System.err.println("error : " + err.getMessage());
        } finally {
            System.exit(0);
        }
    }
}
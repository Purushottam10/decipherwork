package com.decipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author purushottam
 * Main Class
 */

public class Main {
    private static int choice = 0;


    /**
     * This is main Method
     * ask for Input to Perform different operation
     *
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int choice = 0;
        int id = 1;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Operations operation = new Operations();

        do {
            System.out.print("Enter your choice");
            System.out.println("\n1 for Insert \n2 for Display \n3 for Display By Id "
                    + "\n4 for Remove data  \n5 for Update data  \n6.Exit");
            try {
                choice = Integer.parseInt(bufferedReader.readLine());
            } catch (NumberFormatException ex) {
                choice = 0;
                ex.printStackTrace();
            }

            if (choice == 1) {

                operation.addStudent(operation.idgenerate());
            } else if (choice == 2) {
                operation.display();
            } else if (choice == 3) {
                System.out.println("Enter stuent id");
                try {
                    id = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    e.getStackTrace();
                }
                operation.displayById(id);
            } else if (choice == 4) {
                System.out.println("enter the student Id");
                try {
                    id = Integer.parseInt(bufferedReader.readLine());
                } catch (NumberFormatException e) {
                    // TODO: handle exception
                    e.getStackTrace();
                }
                operation.remove(id);
            } else if (choice == 5) {
                operation.update();
            } else if (choice == 6) {
                System.exit(0);
            } else {
                System.out.println(" Inseret a valid choice ");
            }
        }
        while (choice != 6);

    }
    //end of method
}




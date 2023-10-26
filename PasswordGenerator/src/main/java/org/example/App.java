package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        boolean useLowerCase;
        boolean useUpperCase;
        boolean useDigits;
        boolean useSpecialSigns;
        int length;
        PasswordGenerator passwordGenerator;

        do {
            passwordGenerator = new PasswordGenerator();

            System.out.println("Should the password include lower case letters?: yes/no");
            useLowerCase = takeAnswer();

            System.out.println("Should the password include upper case letters?: yes/no");
            useUpperCase = takeAnswer();

            System.out.println("Should the password include digits?: yes/no");
            useDigits = takeAnswer();

            System.out.println("Should the password include special signs?: yes/no");
            useSpecialSigns = takeAnswer();

            Scanner sc = new Scanner(System.in);
            System.out.println("How long should the password be?");

            while (true) {
                try {
                    length = sc.nextInt();
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Your answer is not an integer, try again!");
                }
            }
        } while (!(useLowerCase && useUpperCase && useDigits && useSpecialSigns));

        String password = passwordGenerator.generatePassword(useLowerCase, useUpperCase, useDigits, useSpecialSigns, length);




        System.out.println("password = " + password);

        for(Character myChar : password.toCharArray()) {
            System.out.print((int)myChar + " ");
        }
    }

    private static boolean takeAnswer() {
        Scanner sc = new Scanner(System.in);
        String answer;
        while(true) {
            answer = sc.next();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("value: " + answer + ", is incorrect, try again!");
            }
        }
    }
}

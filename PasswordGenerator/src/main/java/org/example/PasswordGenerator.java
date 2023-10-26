package org.example;

import java.util.Random;

public class PasswordGenerator {

    public String generatePassword(boolean useLowerCase, boolean useUpperCase, boolean useDigits, boolean useSpecialSigns, Integer length) {

        Alphabet alphabet = new Alphabet(useLowerCase, useUpperCase, useDigits, useSpecialSigns);
        String numbers = alphabet.getValue();
        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0; i < length; i++) {
            char currentChar = numbers.charAt(giveRandomNumber(numbers.length()));
            stringBuilder.append(currentChar);
        }
        return stringBuilder.toString();
    }

    public int giveRandomNumber(int number) {
        Random random = new Random();
        return random.nextInt(number);
    }
}

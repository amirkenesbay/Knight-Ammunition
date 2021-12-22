package com.epam.knight.controller;

import java.util.Scanner;

public class Controller {
    private static final String WRONG_COMMAND = "This command does not exist";
    private static final String INVALID_NUMBER = "Invalid number! Try again";

    public int inputNumber(int start, int end) {
        int numberFromUser = 0;
        boolean userInput = false;
        do {
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                do {
                    numberFromUser = scanner.nextInt();
                    if (numberFromUser < start || numberFromUser > end) {
                        System.out.println(WRONG_COMMAND);
                    }
                } while (numberFromUser < start || numberFromUser > end);
                userInput = true;
            } else {
                System.out.println(INVALID_NUMBER);
            }
        } while (!userInput);
        return numberFromUser;
    }
}

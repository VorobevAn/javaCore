package org.seminar4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class DebitAccount extends Account {
    private static Scanner scanner = new Scanner(System.in);

    /**
     * установка первоночального баланса дебетового счета
     */
    public void balance() {
        try {
            initialBalance(scanner.nextInt());
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("не верный ввод.");
            scanner.nextLine();
            balance();
        }
    }
}
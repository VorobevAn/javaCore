package org.seminar4;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Account {
    private static Scanner scanner = new Scanner(System.in);
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public Account() {
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * метод пополнения баланса
     *
     * @param summa передоваемая сумма
     * @throws IllegalArgumentException Сумма пополнения не может быть отрицательной
     */

    public void replenishment(int summa) throws IllegalArgumentException {
        if (summa < 0) {
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной");
        }
        balance += summa;
    }

    /**
     * Снятие со счета
     *
     * @param summs сумма снятия
     * @throws InsufficientFundsException баллан счета не достаточен для снятия
     */
    public void withdrawalOfBalance(int summs) throws InsufficientFundsException, IllegalArgumentException {
        if (balance - summs < 0) {
            throw new InsufficientFundsException("баллан счета не достаточен для снятия");
        } else if (summs < 0) {
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной");
        }
        balance -= summs;
        getBalance();
    }

    /**
     * Установка началтного баланса
     *
     * @param balance передоваеммое значение
     * @throws IllegalArgumentException баланс не может быть отрицательным
     */
    public void initialBalance(int balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException("баланс не может быть отрицательным");
        }

        this.balance = balance;
    }


}

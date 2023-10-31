package org.seminar4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class program {

    private static final Scanner scanner = new Scanner(System.in);
    static CreditAccount creditAccount = new CreditAccount();
    static DebitAccount debitAccount = new DebitAccount();
    static Transaction transaction = new Transaction();

    public static void main(String[] args) throws InsufficientFundsException {
        System.out.println("C каким балансом открыть дебетовый счет:");
        debitAccount.balance();
        program();

    }

    public static void program() {
        try {
            boolean exit = true;
            do {
                System.out.println("Выберите действие: \n 1 - Пополнить счет \n"
                        + " 2 - Снять со счета \n 3 - Открыть кредитный счет \n 4 - Перевести на кредитный счет \n " +
                        "5 - Показать балланс \n 6 - Выход");

                switch (scanner.nextInt()) {
                    case 1 -> {
                        System.out.print("Введите сумму пополнения: \n");
                        debitAccount.replenishment(scanner.nextInt());
                    }
                    case 2 -> {
                        System.out.print("Введите сумму снятия: \n");
                        debitAccount.withdrawalOfBalance(scanner.nextInt());
                    }
                    case 3 -> {
                        creditAccount.setBalance(2000);
                        System.out.println("Кредитный счет открыт баланс: " + creditAccount.getBalance());
                    }

                    case 4 -> {
                        System.out.println("Укажите сумму перевода");
                        transaction.transfer(scanner.nextInt());
                    }

                    case 5 -> {
                        System.out.println("баланс дебетового счета: " + debitAccount.getBalance());
                        System.out.println("баланс кредитного счета: " + creditAccount.getBalance());
                        ;
                    }
                    case 6 -> exit = false;
                }
            } while (exit);
        } catch (InputMismatchException e) {
            System.out.println("Не верный ввод");
            scanner.nextLine();
            program();
        } catch (InsufficientFundsException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
            scanner.nextLine();
            program();
        }
    }
}



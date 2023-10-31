package org.seminar4;

import static org.seminar4.program.creditAccount;
import static org.seminar4.program.debitAccount;

public class Transaction {
    /**
     * Метод перевода с дебетового счета на кредитный
     *
     * @param sum сумма перевода
     * @throws InsufficientFundsException Баланс счета не достаточен для перевода
     */
    public void transfer(int sum) throws InsufficientFundsException {
        if (debitAccount.getBalance() - sum < 0) {
            throw new InsufficientFundsException("Баланс счета не достаточен для перевода");
        }
        creditAccount.replenishment(sum);
        debitAccount.withdrawalOfBalance(sum);

    }
}

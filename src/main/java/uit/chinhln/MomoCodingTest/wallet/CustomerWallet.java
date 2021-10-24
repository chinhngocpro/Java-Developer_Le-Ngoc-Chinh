package uit.chinhln.MomoCodingTest.wallet;

import uit.chinhln.MomoCodingTest.exception.BalanceNotEnoughException;
import uit.chinhln.MomoCodingTest.exception.InvalidValueException;

public interface CustomerWallet {

    /**
     *
     * @param value
     * @return new balance after add {value}
     * @throws InvalidValueException if balance less than zero
     */
    int deposit(int value) throws InvalidValueException;

    /**
     *
     * @param value
     * @return new balance after remove {value}
     * @throws InvalidValueException if balance less than zero
     * @throws BalanceNotEnoughException if balance is less than {value}
     */
    int withdraw(int value) throws InvalidValueException, BalanceNotEnoughException;

    int withdrawAll();

    int checkBalance();
}

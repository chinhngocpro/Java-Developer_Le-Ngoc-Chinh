package uit.chinhln.MomoCodingTest.wallet;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import uit.chinhln.MomoCodingTest.exception.BalanceNotEnoughException;
import uit.chinhln.MomoCodingTest.exception.InvalidValueException;

@Getter @Setter
public class DefaultCustomerWallet implements CustomerWallet{

    Integer balance = 0;

    @Override
    public int deposit(int value) throws InvalidValueException {
        if (value < 0) {
            throw new InvalidValueException("Input value must be greater or equal than ZERO");
        }

        balance += value;

        return balance;
    }

    @Override
    public int withdraw(int value) throws InvalidValueException, BalanceNotEnoughException {
        if (value < 0) {
            throw new InvalidValueException("Input value must not be less than ZERO");
        }

        if (value > balance) {
            throw new BalanceNotEnoughException();
        }

        balance -= value;

        return balance;
    }

    @Override
    public int withdrawAll() {
        int temp = balance;
        balance = 0;
        return temp;
    }

    @Override
    public int checkBalance() {
        return balance;
    }

}

package uit.chinhln.MomoCodingTest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BalanceNotEnoughException extends Exception {
    public BalanceNotEnoughException(String message) {
        super(message);
    }
}

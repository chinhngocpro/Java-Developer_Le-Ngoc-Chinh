package uit.chinhln.MomoCodingTest.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class InvalidValueException extends Exception {

    public InvalidValueException(String message) {
        super(message);
    }
}

package uit.chinhln.MomoCodingTest.exception;

import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
public class InvalidBankNoteValueException extends Exception {

    public InvalidBankNoteValueException(String message) {
        super(message);
    }

    public InvalidBankNoteValueException(Collection<Integer> acceptedValue) {
        super(buildMessage(acceptedValue));
    }

    private static String buildMessage(Collection<Integer> acceptedValue) {
        String values = acceptedValue.stream().map(Object::toString).collect(Collectors.joining(", "));
        String message = String.format("Bank note value must be in %s", values);
        return message;
    }
}

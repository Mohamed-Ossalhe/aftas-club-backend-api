package ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions;

public class UniqueConstraintViolationException extends RuntimeException {
    public UniqueConstraintViolationException(String message) {
        super(message);
    }
}

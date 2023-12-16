package ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions;

public class TimeExpiredException extends RuntimeException{
    public TimeExpiredException(String message) {
        super(message);
    }
}

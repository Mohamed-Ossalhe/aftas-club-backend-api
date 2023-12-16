package ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions;

public class MaxLimitsExceedException extends RuntimeException{
    public MaxLimitsExceedException(String message) {
        super(message);
    }
}

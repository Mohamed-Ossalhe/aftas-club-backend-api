package ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions;

public class MemberNotFoundException extends RuntimeException {
    public MemberNotFoundException(String message) {
        super(message);
    }
}

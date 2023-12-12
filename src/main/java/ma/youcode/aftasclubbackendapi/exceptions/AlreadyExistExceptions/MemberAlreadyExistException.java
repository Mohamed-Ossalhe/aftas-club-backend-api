package ma.youcode.aftasclubbackendapi.exceptions.AlreadyExistExceptions;

public class MemberAlreadyExistException extends RuntimeException {
    public MemberAlreadyExistException(String message) {
        super(message);
    }
}

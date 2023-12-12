package ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions;

public class CompetitionNotFoundException extends RuntimeException {
    public CompetitionNotFoundException(String message) {
        super(message);
    }
}

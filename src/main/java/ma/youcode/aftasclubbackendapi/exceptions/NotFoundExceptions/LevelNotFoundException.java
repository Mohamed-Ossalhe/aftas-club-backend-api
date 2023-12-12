package ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions;

public class LevelNotFoundException extends RuntimeException {
    public LevelNotFoundException(String message) {
        super(message);
    }
}

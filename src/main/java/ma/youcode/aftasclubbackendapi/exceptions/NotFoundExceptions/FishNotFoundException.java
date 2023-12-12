package ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions;

public class FishNotFoundException extends RuntimeException {
    public FishNotFoundException(String message) {
        super(message);
    }
}

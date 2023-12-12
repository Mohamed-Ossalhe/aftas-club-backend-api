package ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions;

public class RankingNotFoundException extends RuntimeException {
    public RankingNotFoundException(String message) {
        super(message);
    }
}

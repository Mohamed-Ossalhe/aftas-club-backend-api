package ma.youcode.aftasclubbackendapi.exceptions;

import ma.youcode.aftasclubbackendapi.exceptions.AlreadyExistExceptions.*;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.*;
import ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions.MaxLimitsExceedException;
import ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions.TimeExpiredException;
import ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions.UniqueConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsHandler {

    /***
     * Handle validation exceptions
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    /***
     *  Resource Not Found Exceptions Handling
     ***/

    /**
     *
     * @param exception {@link CompetitionNotFoundException}
     * @return
     */
    @ExceptionHandler(value = CompetitionNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCompetitionNotFoundException(CompetitionNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Competition Not Found: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    /**
     *
     * @param exception {@link FishNotFoundException}
     * @return
     */
    @ExceptionHandler(value = FishNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFishNotFoundException(FishNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Fish Not Found: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param exception {@link HuntingNotFoundException}
     * @return
     */
    @ExceptionHandler(value = HuntingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleHuntingNotFoundException(HuntingNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Hunting Not Found: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param exception {@link LevelNotFoundException}
     * @return
     */
    @ExceptionHandler(value = LevelNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleLevelNotFoundException(LevelNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Level Not Found: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param exception {@link MemberNotFoundException}
     * @return
     */
    @ExceptionHandler(value = MemberNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMemberNotFoundException(MemberNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Member Not Found: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    /**
     *
     * @param exception {@link RankingNotFoundException}
     * @return
     */
    @ExceptionHandler(value = RankingNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRankingNotFoundException(RankingNotFoundException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.NOT_FOUND, "Ranking Not Found: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


    /***
     * Resource Already Exist Exceptions Handling
     ***/
    /**
     *
     * @param exception {@link CompetitionAlreadyExistException}
     * @return
     */
    @ExceptionHandler(value = CompetitionAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleCompetitionAlreadyExistException(CompetitionAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.FOUND, "Competition Already Exist: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

    /**
     *
     * @param exception {@link FishAlreadyExistException}
     * @return
     */
    @ExceptionHandler(value = FishAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleFishAlreadyExistException(FishAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.FOUND, "Fish Already Exist: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

    /**
     *
     * @param exception {@link HuntingAlreadyExistException}
     * @return
     */
    @ExceptionHandler(value = HuntingAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleHuntingAlreadyExistException(HuntingAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.FOUND, "Hunting Already Exist: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

    /**
     *
     * @param exception {@link LevelAlreadyExistException}
     * @return
     */
    @ExceptionHandler(value = LevelAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleLevelAlreadyExistException(LevelAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.FOUND, "Level Already Exist: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

    /**
     *
     * @param exception {@link MemberAlreadyExistException}
     * @return
     */
    @ExceptionHandler(value = MemberAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleMemberAlreadyExistException(MemberAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.FOUND, "Member Already Exist: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

    /**
     *
     * @param exception {@link RankingAlreadyExistException}
     * @return
     */
    @ExceptionHandler(value = RankingAlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleRankingNotFoundException(RankingAlreadyExistException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.FOUND, "Ranking Already Exist: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.FOUND);
    }

    /***
     * Unique Constraint Violation Exception
     ***/

    /**
     *
     * @param exception {@link UniqueConstraintViolationException}
     * @return
     */
    @ExceptionHandler(UniqueConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleUniqueConstraintViolationException(UniqueConstraintViolationException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.CONFLICT, "Unique values repeated: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    /***
     *  Time Expired Exception
     ***/

    /**
     *
     * @param exception {@link TimeExpiredException}
     * @return
     */
    @ExceptionHandler(TimeExpiredException.class)
    public ResponseEntity<ErrorResponse> handleTimeExpiredException(TimeExpiredException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Time Expired: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /***
     *  Max Limits Exceed Exception
     ***/

    /**
     *
     * @param exception {@link MaxLimitsExceedException}
     * @return
     */
    @ExceptionHandler(MaxLimitsExceedException.class)
    public ResponseEntity<ErrorResponse> handleMaxLimitsException(MaxLimitsExceedException exception) {
        ErrorResponse errorResponse = ErrorResponse.create(exception, HttpStatus.BAD_REQUEST, "Max Limits Exceed: " + exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

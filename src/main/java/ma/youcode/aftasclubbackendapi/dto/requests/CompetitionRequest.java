package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionRequest {
    private String code;

    @NotNull(message = "Date cannot be null")
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$", message = "Invalid date format. Use dd-MM-yyyy")
    private LocalDate date;

    @NotNull(message = "Start Time cannot be null")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Invalid time format. Use HH:mm")
    private LocalTime startTime;

    @NotNull(message = "End Time cannot be null")
    @Pattern(regexp = "^([01]\\d|2[0-3]):([0-5]\\d)$", message = "Invalid time format. Use HH:mm")
    private LocalTime endTime;

    @Min(value = 10, message = "number of participants cannot be inferior than 10")
    @NotNull(message = "number of participants cannot be null")
    private Integer numberOfParticipants;

    @NotNull(message = "Location cannot be null")
    private String location;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 100, message = "Amount cannot be less than 100")
    @Positive(message = "Amount must be positive value")
    private double amount;
}

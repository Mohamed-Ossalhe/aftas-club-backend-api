package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class CompetitionRequest {
    private String code;

    @NotNull(message = "Date cannot be null")
    private LocalDate date;

    @NotNull(message = "Start Time cannot be null")
    private LocalTime startTime;

    @NotNull(message = "End Time cannot be null")
    private LocalTime endTime;

    private Integer numberOfParticipants = 0;

    @NotNull(message = "Location cannot be null")
    private String location;

    @NotNull(message = "Amount cannot be null")
    @Min(value = 1, message = "Amount cannot be less than 1")
    @Positive(message = "Amount must be positive value")
    private double amount;
}

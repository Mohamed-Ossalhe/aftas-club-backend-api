package ma.youcode.aftasclubbackendapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompetitionDto implements Serializable {
    private String code;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer numberOfParticipants;

    private String location;

    private double amount;

//    private List<Hunting> huntings;
//
//    private List<Ranking> ranking;
}

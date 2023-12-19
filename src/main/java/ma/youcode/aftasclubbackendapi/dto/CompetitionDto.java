package ma.youcode.aftasclubbackendapi.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubbackendapi.entities.Hunting;
import ma.youcode.aftasclubbackendapi.entities.Ranking;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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

    private List<HuntingDto> huntings;
//
    private List<RankingDto> ranking;
}

package ma.youcode.aftasclubbackendapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "competitions")
public class Competition {
    @Id
    @Column(unique = true, nullable = false)
    private String code;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer numberOfParticipants;

    private String location;

    private double amount;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
    private List<Ranking> ranking;
}

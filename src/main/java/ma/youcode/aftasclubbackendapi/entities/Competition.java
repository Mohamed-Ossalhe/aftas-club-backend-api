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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer numberOfParticipants;

    private String location;

    private double amount;

    @OneToMany(mappedBy = "competition")
    private List<Hunting> huntings;

    @ManyToOne()
    private Ranking ranking;
}

package ma.youcode.aftasclubbackendapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "levels")
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String description;

    private int points;

    @OneToMany(mappedBy = "level")
    private List<Fish> fish;
}

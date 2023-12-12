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
    private Integer code;

    private String description;

    private Integer points;

    @OneToMany(mappedBy = "level", fetch = FetchType.LAZY)
    private List<Fish> fish;
}

package ma.youcode.aftasclubbackendapi.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "fish")
public class Fish {
    @Id
    @Column(unique = true, nullable = true)
    private String name;

    private double averageWeight;

    @OneToMany(mappedBy = "fish", fetch = FetchType.LAZY)
    private List<Hunting> huntings;

    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "level_id")
    private Level level;
}

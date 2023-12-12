package ma.youcode.aftasclubbackendapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubbackendapi.entities.embedded.RankId;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.awt.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rankings")
public class Ranking {
    @EmbeddedId
    private RankId id;

    private int rank;

    private int score;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "memberId")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_code")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "competitionCode")
    private Competition competition;

}

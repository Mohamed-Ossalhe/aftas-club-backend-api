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

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer rank;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer score;

    @ManyToOne
    @JoinColumn(name = "member_num")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "memberNum")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "competition_code")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @MapsId(value = "competitionCode")
    private Competition competition;

}

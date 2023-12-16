package ma.youcode.aftasclubbackendapi.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RankId implements Serializable {
    @Column(name = "competition_code")
    private String code;
    @Column(name = "member_num")
    private Integer num;
}

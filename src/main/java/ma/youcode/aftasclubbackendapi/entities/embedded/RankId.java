package ma.youcode.aftasclubbackendapi.entities.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class RankId implements Serializable {
    @Column(name = "competition_code")
    private String code;
    @Column(name = "member_num")
    private Integer num;
}

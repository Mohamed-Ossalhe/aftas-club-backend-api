package ma.youcode.aftasclubbackendapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HuntingDto implements Serializable {
    private Integer id;

    private Integer numberOfFish;

    private FishDto fish;

    private MemberDto member;

    private CompetitionDto competition;
}

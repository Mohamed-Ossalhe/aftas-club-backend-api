package ma.youcode.aftasclubbackendapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankingDto {
    private int rank;

    private int score;

    private MemberDto member;

    //private CompetitionDto competition;
}

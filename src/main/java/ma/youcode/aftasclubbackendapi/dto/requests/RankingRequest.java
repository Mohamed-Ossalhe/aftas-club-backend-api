package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RankingRequest {
    private int rank;

    private int score;

    @NotNull(message = "Member cannot be null")
    private MemberRequest member;

    @NotNull(message = "Competition cannot be null")
    private CompetitionRequest competition;
}

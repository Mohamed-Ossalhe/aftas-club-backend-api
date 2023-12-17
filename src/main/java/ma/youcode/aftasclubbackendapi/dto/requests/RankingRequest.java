package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RankingRequest {
    private int rank;

    private int score;

    @NotNull(message = "Member is required")
    private MemberRequest member;

    @NotNull(message = "Competition is required")
    private CompetitionRequest competition;
}

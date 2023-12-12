package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HuntingRequest {
    private Integer id;

    @NotNull(message = "Number of Fish cannot be null")
    private Integer numberOfFish;

    @NotNull(message = "Fish Cannot be null")
    private FishRequest fish;

    @NotNull(message = "Member cannot be null")
    private MemberRequest member;

    @NotNull(message = "Competition cannot be null")
    private CompetitionRequest competition;
}

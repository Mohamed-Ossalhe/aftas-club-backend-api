package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class LevelRequest {
    private Integer code;

    @NotNull(message = "Description cannot be null")
    private String description;

    @NotNull(message = "Points cannot be null")
    @Positive(message = "Points must be positive value")
    private Integer points;
}

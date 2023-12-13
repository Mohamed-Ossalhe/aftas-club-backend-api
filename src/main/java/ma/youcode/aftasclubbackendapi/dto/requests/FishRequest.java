package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class FishRequest {
    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Average Weight cannot be null")
    @Positive(message = "average Weight must be Positive value")
    private double averageWeight;

    @NotNull(message = "Level cannot be null")
    private LevelRequest level;
}

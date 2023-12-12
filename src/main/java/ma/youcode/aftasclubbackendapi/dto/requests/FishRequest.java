package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ma.youcode.aftasclubbackendapi.dto.LevelDto;

@Data
public class FishRequest {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Average Weight cannot be null")
    private double averageWeight;

    @NotNull(message = "Level cannot be null")
    private LevelRequest level;
}

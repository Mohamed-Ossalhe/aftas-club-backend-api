package ma.youcode.aftasclubbackendapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FishDto implements Serializable {
    private String name;

    private double averageWeight;

    private LevelDto level;
}

package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;

import java.time.LocalDate;

@Data
public class MemberRequest {
    private Integer num;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Family Name cannot be null")
    private String familyName;

    private LocalDate accessionDate = LocalDate.now();

    @NotNull(message = "nationality cannot be null")
    private String nationality;

    @NotNull(message = "Identity Document cannot be null")
    private IdentityDocument identityDocument;

    @NotNull(message = "Identity Number cannot be null")
    private String identityNumber;
}

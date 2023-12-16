package ma.youcode.aftasclubbackendapi.dto.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;

import java.time.LocalDate;

@Data
public class MemberRequest {
    private Integer num;

    @NotNull(message = "Name is required")
    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Family Name is required")
    @NotBlank(message = "Family Name is required")
    private String familyName;

    private LocalDate accessionDate = LocalDate.now();

    @NotNull(message = "nationality is required")
    @NotBlank(message = "nationality is required")
    private String nationality;

    @NotNull(message = "Identity Document is required")
    @NotBlank(message = "Identity Document is required")
    private String identityDocument;

    @NotNull(message = "Identity Number is required")
    @NotBlank(message = "Identity Number is required")
    private String identityNumber;
}

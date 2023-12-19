package ma.youcode.aftasclubbackendapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto implements Serializable {
    private Integer num;

    private String name;

    private String familyName;

    private LocalDate accessionDate;

    private String nationality;

    private IdentityDocument identityDocument;

    private String identityNumber;

//    private List<HuntingDto> hunting;

//    private List<Ranking> ranking;
}

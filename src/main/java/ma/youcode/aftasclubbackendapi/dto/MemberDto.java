package ma.youcode.aftasclubbackendapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;

import java.io.Serializable;
import java.time.LocalDate;

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

//    private List<Hunting> hunting;

//    private List<Ranking> ranking;
}

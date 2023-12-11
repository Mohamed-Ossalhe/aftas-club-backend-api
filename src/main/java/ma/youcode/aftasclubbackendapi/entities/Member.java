package ma.youcode.aftasclubbackendapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;

import java.sql.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    private String name;

    private String familtyName;

    private Date accessionDate;

    private String nationality;

    @Enumerated(EnumType.STRING)
    private IdentityDocument identityDocument;

    private String identityNumber;

    @OneToMany(mappedBy = "member")
    private List<Hunting> huntings;

    @OneToMany(mappedBy = "member")
    private List<Ranking> ranking;
}

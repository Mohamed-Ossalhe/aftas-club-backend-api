package ma.youcode.aftasclubbackendapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer num;

    private String name;

    private String familyName;

    private LocalDate accessionDate;

    private String nationality;

    @Enumerated(EnumType.STRING)
    private IdentityDocument identityDocument;

    @Column(unique = true, nullable = false)
    private String identityNumber;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Hunting> hunting;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Ranking> ranking;
}

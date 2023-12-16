package ma.youcode.aftasclubbackendapi.repositories;

import ma.youcode.aftasclubbackendapi.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    public Optional<Member> findByIdentityNumber(String identityNumber);
}

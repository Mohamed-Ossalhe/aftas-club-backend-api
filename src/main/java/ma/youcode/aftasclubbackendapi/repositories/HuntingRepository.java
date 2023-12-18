package ma.youcode.aftasclubbackendapi.repositories;

import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.entities.Fish;
import ma.youcode.aftasclubbackendapi.entities.Hunting;
import ma.youcode.aftasclubbackendapi.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HuntingRepository extends JpaRepository<Hunting, Integer> {
    Optional<Hunting> findHuntingByCompetitionAndMemberAndFish(Competition competition, Member member, Fish fish);
}

package ma.youcode.aftasclubbackendapi.repositories;

import ma.youcode.aftasclubbackendapi.entities.Ranking;
import ma.youcode.aftasclubbackendapi.entities.embedded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {
}

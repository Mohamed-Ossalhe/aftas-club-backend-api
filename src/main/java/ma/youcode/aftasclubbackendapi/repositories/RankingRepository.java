package ma.youcode.aftasclubbackendapi.repositories;

import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.entities.Ranking;
import ma.youcode.aftasclubbackendapi.entities.embedded.RankId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, RankId> {
    List<Ranking> findDistinctTop3ByCompetitionCodeOrderByScoreDesc(String code);
    List<Ranking> findAllByCompetitionOrderByScoreDesc(Competition competition);
}

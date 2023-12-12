package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.entities.Ranking;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface RankingService {
    public Optional<Ranking> save(Ranking rank);
}

package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.entities.Ranking;

import java.util.Optional;

public interface RankingService {
    public Optional<Ranking> save(Ranking rank);
}

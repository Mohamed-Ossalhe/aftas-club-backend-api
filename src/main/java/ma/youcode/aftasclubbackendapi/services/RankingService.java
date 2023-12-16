package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.RankingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.RankingRequest;
import ma.youcode.aftasclubbackendapi.entities.Ranking;
import ma.youcode.aftasclubbackendapi.entities.embedded.RankId;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

import java.util.Optional;

public interface RankingService extends ICrud<RankingDto, RankingRequest, RankId> {
}

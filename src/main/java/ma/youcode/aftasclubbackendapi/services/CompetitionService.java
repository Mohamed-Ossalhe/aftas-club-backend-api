package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.CompetitionDto;
import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface CompetitionService extends ICrud<Competition, CompetitionDto, String> {
}

package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.CompetitionDto;
import ma.youcode.aftasclubbackendapi.dto.requests.CompetitionRequest;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface CompetitionService extends ICrud<CompetitionDto, CompetitionRequest, String> {
}

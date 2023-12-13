package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.LevelDto;
import ma.youcode.aftasclubbackendapi.dto.requests.LevelRequest;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface LevelService extends ICrud<LevelDto, LevelRequest, Integer> {
}

package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.LevelDto;
import ma.youcode.aftasclubbackendapi.entities.Level;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;
import org.springframework.stereotype.Service;

@Service
public interface LevelService extends ICrud<Level, LevelDto, Integer> {
}

package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.FishDto;
import ma.youcode.aftasclubbackendapi.entities.Fish;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;
import org.springframework.stereotype.Service;

@Service
public interface FishService extends ICrud<Fish, FishDto, String> {
}

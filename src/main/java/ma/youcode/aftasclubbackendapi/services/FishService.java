package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.FishDto;
import ma.youcode.aftasclubbackendapi.entities.Fish;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface FishService extends ICrud<Fish, FishDto, String> {
}

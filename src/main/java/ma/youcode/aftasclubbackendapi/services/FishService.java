package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.FishDto;
import ma.youcode.aftasclubbackendapi.dto.requests.FishRequest;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface FishService extends ICrud<FishDto, FishRequest, String> {
}

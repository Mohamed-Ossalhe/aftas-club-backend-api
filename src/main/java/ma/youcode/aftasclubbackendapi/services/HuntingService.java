package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.HuntingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.HuntingRequest;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface HuntingService extends ICrud<HuntingDto, HuntingRequest, Integer> {
}

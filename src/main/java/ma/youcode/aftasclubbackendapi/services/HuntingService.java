package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.HuntingDto;
import ma.youcode.aftasclubbackendapi.entities.Hunting;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface HuntingService extends ICrud<Hunting, HuntingDto, Integer> {
}

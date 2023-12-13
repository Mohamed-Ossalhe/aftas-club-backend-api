package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.MemberDto;
import ma.youcode.aftasclubbackendapi.dto.requests.MemberRequest;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface MemberService extends ICrud<MemberDto, MemberRequest, Integer> {
}

package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.MemberDto;
import ma.youcode.aftasclubbackendapi.entities.Member;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;

public interface MemberService extends ICrud<Member, MemberDto, Integer> {
}

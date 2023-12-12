package ma.youcode.aftasclubbackendapi.services;

import ma.youcode.aftasclubbackendapi.dto.MemberDto;
import ma.youcode.aftasclubbackendapi.entities.Member;
import ma.youcode.aftasclubbackendapi.interfaces.ICrud;
import org.springframework.stereotype.Service;

@Service
public interface MemberService extends ICrud<Member, MemberDto, Integer> {
}

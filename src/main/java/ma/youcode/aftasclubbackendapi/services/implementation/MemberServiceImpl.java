package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.MemberDto;
import ma.youcode.aftasclubbackendapi.dto.requests.MemberRequest;
import ma.youcode.aftasclubbackendapi.entities.Level;
import ma.youcode.aftasclubbackendapi.entities.Member;
import ma.youcode.aftasclubbackendapi.enums.IdentityDocument;
import ma.youcode.aftasclubbackendapi.exceptions.AlreadyExistExceptions.MemberAlreadyExistException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.MemberNotFoundException;
import ma.youcode.aftasclubbackendapi.repositories.MemberRepository;
import ma.youcode.aftasclubbackendapi.services.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper mapper;

    @Override
    public List<MemberDto> getAll() {
        List<Member> members = memberRepository.findAll();
        if (members.isEmpty())
            throw new MemberNotFoundException("No Members Found");
        return members.stream().map(member -> mapper.map(member, MemberDto.class)).toList();
    }

    @Override
    public Page<MemberDto> getAll(Pageable pageable) {
        Page<Member> members = memberRepository.findAll(pageable);
        if (members.isEmpty())
            throw new MemberNotFoundException("No Members Found");
        return members.map(member -> mapper.map(member, MemberDto.class));
    }

    @Override
    public Optional<MemberDto> find(Integer id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isEmpty())
            throw new MemberNotFoundException("Member not Found with Id: " + id);
        return Optional.of(mapper.map(member.get(), MemberDto.class));
    }

    @Override
    public Optional<MemberDto> create(MemberRequest memberRequest) {
        if (memberRepository.findByIdentityNumber(memberRequest.getIdentityNumber()).isPresent())
            throw new MemberAlreadyExistException("Member is Already exist with id: " + memberRequest.getIdentityNumber());
        else {
            Member member = mapper.map(memberRequest, Member.class);
            Member savedMember = memberRepository.save(member);
            return Optional.of(mapper.map(savedMember, MemberDto.class));
        }
    }

    @Override
    public Optional<MemberDto> update(MemberRequest memberRequest, Integer id) {
        Optional<Member> levelOptional = memberRepository.findById(id);
        if (levelOptional.isEmpty())
            throw new MemberNotFoundException("Member not Found with Id: " + id);
        else {
            Member member = levelOptional.get();
            member.setName(memberRequest.getName());
            member.setFamilyName(memberRequest.getFamilyName());
            member.setAccessionDate(memberRequest.getAccessionDate());
            member.setNationality(memberRequest.getNationality());
            member.setIdentityDocument(IdentityDocument.valueOf(memberRequest.getIdentityDocument()));
            member.setIdentityNumber(memberRequest.getIdentityNumber());
            Member updatedMember = memberRepository.save(member);
            return Optional.of(mapper.map(updatedMember, MemberDto.class));
        }
    }

    @Override
    public boolean destroy(Integer id) {
        Optional<Member> member = memberRepository.findById(id);
        if (member.isPresent()) {
            memberRepository.delete(member.get());
            return true;
        } else throw new MemberNotFoundException("Member not Found with Id: " + id);
    }
}

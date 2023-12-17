package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.HuntingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.HuntingRequest;
import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.entities.Fish;
import ma.youcode.aftasclubbackendapi.entities.Hunting;
import ma.youcode.aftasclubbackendapi.entities.Member;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.CompetitionNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.FishNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.HuntingNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.MemberNotFoundException;
import ma.youcode.aftasclubbackendapi.repositories.CompetitionRepository;
import ma.youcode.aftasclubbackendapi.repositories.FishRepository;
import ma.youcode.aftasclubbackendapi.repositories.HuntingRepository;
import ma.youcode.aftasclubbackendapi.repositories.MemberRepository;
import ma.youcode.aftasclubbackendapi.services.HuntingService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HuntingServiceImpl implements HuntingService {

    private final HuntingRepository huntingRepository;
    private final MemberRepository memberRepository;
    private final CompetitionRepository competitionRepository;
    private final FishRepository fishRepository;
    private final ModelMapper mapper;

    @Override
    public List<HuntingDto> getAll() {
        List<Hunting> hunts = huntingRepository.findAll();
        if (hunts.isEmpty())
            throw new HuntingNotFoundException("No Hunts Found");
        return hunts.stream().map(hunting -> mapper.map(hunting, HuntingDto.class)).toList();
    }

    @Override
    public Page<HuntingDto> getAll(Pageable pageable) {
        Page<Hunting> huntsPage = huntingRepository.findAll(pageable);
        if (huntsPage.isEmpty())
            throw new HuntingNotFoundException("No Hunts Found");
        return huntsPage.map(hunting -> mapper.map(hunting, HuntingDto.class));
    }

    @Override
    public Optional<HuntingDto> find(Integer id) {
        Optional<Hunting> hunting = huntingRepository.findById(id);
        if (hunting.isEmpty())
            throw new HuntingNotFoundException("Hunting not Found with Id: " + id);
        return Optional.of(mapper.map(hunting.get(), HuntingDto.class));
    }

    @Override
    public Optional<HuntingDto> create(HuntingRequest huntingRequest) {
        Member member = memberRepository.findById(huntingRequest.getMember().getNum())
                .orElseThrow(() -> new MemberNotFoundException("Member not Found with Id: " + huntingRequest.getMember().getNum()));
        Competition competition = competitionRepository.findById(huntingRequest.getCompetition().getCode())
                .orElseThrow(() -> new CompetitionNotFoundException("Competition not Found with Id: " + huntingRequest.getCompetition().getCode()));
        Fish fish = fishRepository.findById(huntingRequest.getFish().getName())
                .orElseThrow(() -> new FishNotFoundException("Fish not Found with Name: " + huntingRequest.getFish().getName()));

        return Optional.of(mapper.map(huntingRequest, HuntingDto.class));
    }

    @Override
    public Optional<HuntingDto> update(HuntingRequest huntingRequest, Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean destroy(Integer id) {
        Optional<Hunting> hunting = huntingRepository.findById(id);
        if (hunting.isPresent()) {
            huntingRepository.delete(hunting.get());
            return true;
        }else throw new HuntingNotFoundException("Hunting not Found with Id: " + id);
    }
}

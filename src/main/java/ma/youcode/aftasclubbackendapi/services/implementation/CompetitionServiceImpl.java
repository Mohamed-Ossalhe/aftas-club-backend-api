package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.CompetitionDto;
import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.exceptions.NotFoundExceptions.CompetitionNotFoundException;
import ma.youcode.aftasclubbackendapi.exceptions.ValidationExceptions.UniqueConstraintViolationException;
import ma.youcode.aftasclubbackendapi.repositories.CompetitionRepository;
import ma.youcode.aftasclubbackendapi.services.CompetitionService;
import ma.youcode.aftasclubbackendapi.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {

    private final CompetitionRepository competitionRepository;
    private final ModelMapper mapper;
    // date formatter
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @Override
    public List<Competition> getAll() {
        return competitionRepository.findAll();
    };

    @Override
    public Page<Competition> getAll(Pageable pageable) {
        return competitionRepository.findAll(pageable);
    }

    @Override
    public Optional<Competition> find(String code) {
        Optional<Competition> competition = competitionRepository.findById(code);
        if (competition.isPresent())
            return competition;
        throw new CompetitionNotFoundException("Competition Resource Not Found with Code: " + code);
    }

    @Override
    public Optional<Competition> create(CompetitionDto competitionDto) {
        if (competitionRepository.getCompetitionByDate(competitionDto.getDate()).isPresent())
            throw new UniqueConstraintViolationException("Competition is Already Exist With Date: " + competitionDto.getDate());
        else {
            Competition competition = mapper.map(competitionDto, Competition.class);
            competition.setCode(Utils.generateCode(competition.getLocation()));
            return Optional.of(competition);
        }
    }

    @Override
    public Optional<Competition> update(CompetitionDto competitionDto) {
        return Optional.empty();
    }

    @Override
    public boolean destroy(String s) {
        return false;
    }
}

package ma.youcode.aftasclubbackendapi.services.implementation;

import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.dto.CompetitionDto;
import ma.youcode.aftasclubbackendapi.dto.requests.CompetitionRequest;
import ma.youcode.aftasclubbackendapi.entities.Competition;
import ma.youcode.aftasclubbackendapi.exceptions.AlreadyExistExceptions.CompetitionAlreadyExistException;
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
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class CompetitionServiceImpl implements CompetitionService {
    private final CompetitionRepository competitionRepository;
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyy");
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
    private final ModelMapper mapper;

    @Override
    public List<CompetitionDto> getAll() {
        List<Competition> competitions = competitionRepository.findAll();
        if (competitions.isEmpty())
            throw new CompetitionNotFoundException("No Competitions Found");
        return competitions.stream().map(competition -> mapper.map(competition, CompetitionDto.class)).toList();
    }

    @Override
    public Page<CompetitionDto> getAll(Pageable pageable) {
        Page<Competition> competitionPagination = competitionRepository.findAll(pageable);
        if (competitionPagination.isEmpty())
            throw new CompetitionNotFoundException("No Competitions Found");
        return competitionPagination.map(competition -> mapper.map(competition, CompetitionDto.class));
    }

    @Override
    public Optional<CompetitionDto> find(String s) {
        Optional<Competition> competition = competitionRepository.findById(s);
        if (competition.isEmpty())
            throw new CompetitionNotFoundException("Competition Resource Not Found with Code: " + s);
        return Optional.of(mapper.map(competition.get(), CompetitionDto.class));
    }

    @Override
    public Optional<CompetitionDto> create(CompetitionRequest competitionRequest) {
        if (competitionRepository.getCompetitionByDate(LocalDate.parse(competitionRequest.getDate(), dateFormatter)).isPresent())
            throw new CompetitionAlreadyExistException("Competition Already Exists with Date: " + competitionRequest.getDate());
        else {
            Competition competition = mapper.map(competitionRequest, Competition.class);
            competition.setCode(Utils.generateCode(competitionRequest.getLocation(), competitionRequest.getDate()));
            competition.setDate(LocalDate.parse(competitionRequest.getDate(), dateFormatter));
            competition.setStartTime(LocalTime.parse(competitionRequest.getStartTime(), timeFormatter));
            competition.setEndTime(LocalTime.parse(competitionRequest.getEndTime(), timeFormatter));
            competition.setLocation(competitionRequest.getLocation().toLowerCase());

            Competition savedCompetition = competitionRepository.save(competition);
            return Optional.of(mapper.map(savedCompetition, CompetitionDto.class));
        }
    }

    @Override
    public Optional<CompetitionDto> update(CompetitionRequest competitionRequest, String code) {
        if (competitionRepository.findById(code).isEmpty())
            throw new CompetitionNotFoundException("Competition Not Found With Code: " + code);
        else {
            Competition competition = mapper.map(competitionRequest, Competition.class);
            competition.setCode(Utils.generateCode(competitionRequest.getLocation(), competitionRequest.getDate()));
            competition.setDate(LocalDate.parse(competitionRequest.getDate(), dateFormatter));
            competition.setStartTime(LocalTime.parse(competitionRequest.getStartTime(), timeFormatter));
            competition.setEndTime(LocalTime.parse(competitionRequest.getEndTime(), timeFormatter));
            competition.setLocation(competitionRequest.getLocation().toLowerCase());

            Competition updatedCompetition = competitionRepository.save(competition);
            return Optional.of(mapper.map(updatedCompetition, CompetitionDto.class));
        }
    }

    @Override
    public boolean destroy(String s) {
        Optional<Competition> competition = competitionRepository.findById(s);
        if (competition.isPresent()) {
            competitionRepository.deleteById(s);
            return true;
        } else throw new CompetitionNotFoundException("Competition Not Found With Code: " + s);
    }
}

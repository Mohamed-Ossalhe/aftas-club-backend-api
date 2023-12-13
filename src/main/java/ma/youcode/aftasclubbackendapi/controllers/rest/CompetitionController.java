package ma.youcode.aftasclubbackendapi.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.CompetitionDto;
import ma.youcode.aftasclubbackendapi.dto.requests.CompetitionRequest;
import ma.youcode.aftasclubbackendapi.repositories.CompetitionRepository;
import ma.youcode.aftasclubbackendapi.services.CompetitionService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/competitions")
@RequiredArgsConstructor
public class CompetitionController implements IController<CompetitionRequest, CompetitionDto, String> {

    private final CompetitionService competitionService;

    @Override
    @GetMapping("/{code}")
    public ResponseEntity<CompetitionDto> get(@PathVariable String code) {
        Optional<CompetitionDto> competition = competitionService.find(code);
        assert competition.isPresent();
        return new ResponseEntity<>(competition.get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<CompetitionDto>> getAll() {
        return new ResponseEntity<>(competitionService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<CompetitionDto>> getAllPaginated(Pageable pageable) {
        return new ResponseEntity<>(competitionService.getAll(pageable), HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<CompetitionDto> create(@Valid @RequestBody CompetitionRequest competitionRequest) {
        Optional<CompetitionDto> competitionCreated = competitionService.create(competitionRequest);
        assert competitionCreated.isPresent();
        return new ResponseEntity<>(competitionCreated.get(), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<CompetitionDto> update(CompetitionRequest competitionRequest, String s) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> destroy(String s) {
        return null;
    }
}

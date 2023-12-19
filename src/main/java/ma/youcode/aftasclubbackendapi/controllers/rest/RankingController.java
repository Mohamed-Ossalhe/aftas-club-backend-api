package ma.youcode.aftasclubbackendapi.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.RankingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.RankingRequest;
import ma.youcode.aftasclubbackendapi.entities.embedded.RankId;
import ma.youcode.aftasclubbackendapi.services.RankingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/rankings")
@RequiredArgsConstructor
@CrossOrigin("*")
public class RankingController implements IController<RankingRequest, RankingDto, RankId> {

    private final RankingService rankingService;

    @Override
    @GetMapping("/{rankId}")
    public ResponseEntity<RankingDto> get(@PathVariable RankId rankId) {
        Optional<RankingDto> rankingDto = rankingService.find(rankId);
        assert rankingDto.isPresent();
        return new ResponseEntity<>(rankingDto.get(), HttpStatus.FOUND);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<RankingDto>> getAll() {
        return new ResponseEntity<>(rankingService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<RankingDto>> getAllPaginated(Pageable pageable) {
        return new ResponseEntity<>(rankingService.getAll(pageable), HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<RankingDto> create(@Valid @RequestBody RankingRequest rankingRequest) {
        Optional<RankingDto> savedRanking = rankingService.create(rankingRequest);
        assert savedRanking.isPresent();
        return new ResponseEntity<>(savedRanking.get(), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{rankId}/update")
    public ResponseEntity<RankingDto> update(@Valid @RequestBody RankingRequest rankingRequest, @PathVariable RankId rankId) {
        return null;
    }

    @Override
    @DeleteMapping("/{rankId}/delete")
    public ResponseEntity<Map<String, String>> destroy(@PathVariable RankId rankId) {
        Map<String, String> messages = new HashMap<>();
        if (rankingService.destroy(rankId)) messages.put("message", "Ranking Deleted Successfully");
        else messages.put("message", "Couldn't Delete Ranking");
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}

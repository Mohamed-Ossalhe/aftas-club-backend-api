package ma.youcode.aftasclubbackendapi.controllers.rest;

import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.CompetitionDto;
import ma.youcode.aftasclubbackendapi.dto.requests.CompetitionRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/competitions")
public class CompetitionController implements IController<CompetitionRequest, CompetitionDto, String> {
    @Override
    public ResponseEntity<CompetitionDto> get(String s) {
        return null;
    }

    @Override
    public ResponseEntity<List<CompetitionDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<Page<CompetitionDto>>> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<CompetitionDto> create(CompetitionRequest competitionRequest) {
        return null;
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

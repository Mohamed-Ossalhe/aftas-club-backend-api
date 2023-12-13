package ma.youcode.aftasclubbackendapi.controllers.rest;

import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.LevelDto;
import ma.youcode.aftasclubbackendapi.dto.requests.LevelRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/levels")
public class LevelController implements IController<LevelRequest, LevelDto, Integer> {
    @Override
    public ResponseEntity<LevelDto> get(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<List<LevelDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Page<LevelDto>> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<LevelDto> create(LevelRequest levelRequest) {
        return null;
    }

    @Override
    public ResponseEntity<LevelDto> update(LevelRequest levelRequest, Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> destroy(Integer integer) {
        return null;
    }
}

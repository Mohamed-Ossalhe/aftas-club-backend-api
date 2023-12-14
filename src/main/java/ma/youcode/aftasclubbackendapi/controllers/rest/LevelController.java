package ma.youcode.aftasclubbackendapi.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.LevelDto;
import ma.youcode.aftasclubbackendapi.dto.requests.LevelRequest;
import ma.youcode.aftasclubbackendapi.services.LevelService;
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
@RequestMapping("/api/v1/levels")
@RequiredArgsConstructor
@CrossOrigin("*") // TODO: this should be the frontend url only
public class LevelController implements IController<LevelRequest, LevelDto, Integer> {

    private final LevelService levelService;

    @Override
    @GetMapping("/{code}")
    public ResponseEntity<LevelDto> get(@PathVariable Integer code) {
        Optional<LevelDto> levelDto = levelService.find(code);
        assert levelDto.isPresent();
        return new ResponseEntity<>(levelDto.get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<LevelDto>> getAll() {
        return new ResponseEntity<>(levelService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<LevelDto>> getAllPaginated(Pageable pageable) {
        return new ResponseEntity<>(levelService.getAll(pageable), HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<LevelDto> create(@Valid @RequestBody LevelRequest levelRequest) {
        Optional<LevelDto> createdLevel = levelService.create(levelRequest);
        assert createdLevel.isPresent();
        return new ResponseEntity<>(createdLevel.get(), HttpStatus.OK);
    }

    @Override
    @PatchMapping("/{code}/update")
    public ResponseEntity<LevelDto> update(@Valid @RequestBody LevelRequest levelRequest, @PathVariable Integer code) {
        Optional<LevelDto> updatedLevel = levelService.update(levelRequest, code);
        assert updatedLevel.isPresent();
        return new ResponseEntity<>(updatedLevel.get(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{code}/delete")
    public ResponseEntity<Map<String, String>> destroy(Integer code) {
        Map<String, String> messages = new HashMap<>();
        if (levelService.destroy(code)) messages.put("message", "Level Deleted Successfully");
        else messages.put("message", "Couldn't Delete Level");
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}

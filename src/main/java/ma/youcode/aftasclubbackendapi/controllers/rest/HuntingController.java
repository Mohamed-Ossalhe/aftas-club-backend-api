package ma.youcode.aftasclubbackendapi.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.HuntingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.HuntingRequest;
import ma.youcode.aftasclubbackendapi.services.HuntingService;
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
@RequestMapping("/api/v1/hunts")
@RequiredArgsConstructor
@CrossOrigin("*") // TODO: this should be the frontend url only
public class HuntingController implements IController<HuntingRequest, HuntingDto, Integer> {

    private final HuntingService huntingService;
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<HuntingDto> get(@PathVariable Integer id) {
        Optional<HuntingDto> hunt = huntingService.find(id);
        assert hunt.isPresent();
        return new ResponseEntity<>(hunt.get(), HttpStatus.FOUND);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<HuntingDto>> getAll() {
        return new ResponseEntity<>(huntingService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<HuntingDto>> getAllPaginated(Pageable pageable) {
        return new ResponseEntity<>(huntingService.getAll(pageable), HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<HuntingDto> create(@Valid @RequestBody HuntingRequest huntingRequest) {
        Optional<HuntingDto> savedHunt = huntingService.create(huntingRequest);
        assert savedHunt.isPresent();
        return new ResponseEntity<>(savedHunt.get(), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<HuntingDto> update(@Valid @RequestBody HuntingRequest huntingRequest, @PathVariable Integer id) {
        Optional<HuntingDto> updatedHunt = huntingService.update(huntingRequest, id);
        assert updatedHunt.isPresent();
        return new ResponseEntity<>(updatedHunt.get(), HttpStatus.CREATED);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> destroy(@PathVariable Integer id) {
        Map<String, String> messages = new HashMap<>();
        if (huntingService.destroy(id)) messages.put("message", "Hunt Deleted Successfully");
        else messages.put("message", "Hunt couldn't be Deleted");
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}

package ma.youcode.aftasclubbackendapi.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.FishDto;
import ma.youcode.aftasclubbackendapi.dto.requests.FishRequest;
import ma.youcode.aftasclubbackendapi.services.FishService;
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
@RequestMapping("/api/v1/fish")
@RequiredArgsConstructor
@CrossOrigin("*") // TODO: this should be the frontend url only
public class FishController implements IController<FishRequest, FishDto, String> {

    private final FishService fishService;
    @Override
    @GetMapping("/{name}")
    public ResponseEntity<FishDto> get(@PathVariable String name) {
        Optional<FishDto> fishDto = fishService.find(name);
        assert fishDto.isPresent();
        return new ResponseEntity<>(fishDto.get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<FishDto>> getAll() {
        return new ResponseEntity<>(fishService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<FishDto>> getAllPaginated(Pageable pageable) {
        return new ResponseEntity<>(fishService.getAll(pageable), HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<FishDto> create(@Valid @RequestBody FishRequest fishRequest) {
        Optional<FishDto> fishDto = fishService.create(fishRequest);
        assert fishDto.isPresent();
        return new ResponseEntity<>(fishDto.get(), HttpStatus.OK);
    }

    @Override
    @PatchMapping("/{name}/update")
    public ResponseEntity<FishDto> update(@Valid @RequestBody FishRequest fishRequest, @PathVariable String name) {
        Optional<FishDto> fishDto = fishService.update(fishRequest, name);
        assert fishDto.isPresent();
        return new ResponseEntity<>(fishDto.get(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{name}/delete")
    public ResponseEntity<Map<String, String>> destroy(@PathVariable String name) {
        Map<String, String> messages = new HashMap<>();
        if (fishService.destroy(name)) messages.put("message", "Competition Deleted Successfully");
        else messages.put("message", "Couldn't Delete Competition");
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}

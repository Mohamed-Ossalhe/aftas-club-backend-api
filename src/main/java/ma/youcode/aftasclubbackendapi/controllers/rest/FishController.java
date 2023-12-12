package ma.youcode.aftasclubbackendapi.controllers.rest;

import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.FishDto;
import ma.youcode.aftasclubbackendapi.dto.requests.FishRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/fish")
public class FishController implements IController<FishRequest, FishDto, String> {
    @Override
    public ResponseEntity<FishDto> get(String s) {
        return null;
    }

    @Override
    public ResponseEntity<List<FishDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<Page<FishDto>>> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<FishDto> create(FishRequest fishRequest) {
        return null;
    }

    @Override
    public ResponseEntity<FishDto> update(FishRequest fishRequest, String s) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> destroy(String s) {
        return null;
    }
}

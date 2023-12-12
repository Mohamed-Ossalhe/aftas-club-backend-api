package ma.youcode.aftasclubbackendapi.controllers.rest;

import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.HuntingDto;
import ma.youcode.aftasclubbackendapi.dto.requests.HuntingRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/hunts")
public class HuntingController implements IController<HuntingRequest, HuntingDto, Integer> {
    @Override
    public ResponseEntity<HuntingDto> get(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<List<HuntingDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<List<Page<HuntingDto>>> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<HuntingDto> create(HuntingRequest huntingRequest) {
        return null;
    }

    @Override
    public ResponseEntity<HuntingDto> update(HuntingRequest huntingRequest, Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> destroy(Integer integer) {
        return null;
    }
}

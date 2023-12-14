package ma.youcode.aftasclubbackendapi.controllers.rest;

import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.MemberDto;
import ma.youcode.aftasclubbackendapi.dto.requests.MemberRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/members")
@CrossOrigin("*") // TODO: this should be the frontend url only
public class MemberController implements IController<MemberRequest, MemberDto, Integer> {
    @Override
    public ResponseEntity<MemberDto> get(Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<List<MemberDto>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<Page<MemberDto>> getAllPaginated(Pageable pageable) {
        return null;
    }

    @Override
    public ResponseEntity<MemberDto> create(MemberRequest memberRequest) {
        return null;
    }

    @Override
    public ResponseEntity<MemberDto> update(MemberRequest memberRequest, Integer integer) {
        return null;
    }

    @Override
    public ResponseEntity<Map<String, String>> destroy(Integer integer) {
        return null;
    }
}

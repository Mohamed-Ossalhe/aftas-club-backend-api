package ma.youcode.aftasclubbackendapi.controllers.rest;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ma.youcode.aftasclubbackendapi.controllers.IController;
import ma.youcode.aftasclubbackendapi.dto.MemberDto;
import ma.youcode.aftasclubbackendapi.dto.requests.MemberRequest;
import ma.youcode.aftasclubbackendapi.services.MemberService;
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
@RequestMapping("/api/v1/members")
@RequiredArgsConstructor
@CrossOrigin("*") // TODO: this should be the frontend url only
public class MemberController implements IController<MemberRequest, MemberDto, Integer> {
    private final MemberService memberService;
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<MemberDto> get(@PathVariable Integer id) {
        Optional<MemberDto> member = memberService.find(id);
        assert member.isPresent();
        return new ResponseEntity<>(member.get(), HttpStatus.OK);
    }

    @Override
    @GetMapping("/all")
    public ResponseEntity<List<MemberDto>> getAll() {
        return new ResponseEntity<>(memberService.getAll(), HttpStatus.OK);
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<MemberDto>> getAllPaginated(Pageable pageable) {
        return new ResponseEntity<>(memberService.getAll(pageable), HttpStatus.OK);
    }

    @Override
    @PostMapping("/create")
    public ResponseEntity<MemberDto> create(@Valid @RequestBody MemberRequest memberRequest) {
        Optional<MemberDto> savedMember = memberService.create(memberRequest);
        assert savedMember.isPresent();
        return new ResponseEntity<>(savedMember.get(), HttpStatus.CREATED);
    }

    @Override
    @PatchMapping("/{id}/update")
    public ResponseEntity<MemberDto> update(@Valid @RequestBody MemberRequest memberRequest, @PathVariable Integer id) {
        Optional<MemberDto> updateMember = memberService.update(memberRequest, id);
        assert updateMember.isPresent();
        return new ResponseEntity<>(updateMember.get(), HttpStatus.OK);
    }

    @Override
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Map<String, String>> destroy(@PathVariable Integer id) {
        Map<String, String> messages = new HashMap<>();
        if (memberService.destroy(id)) messages.put("message", "Member Deleted Successfully");
        else messages.put("message", "Member couldn't be deleted");
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }
}

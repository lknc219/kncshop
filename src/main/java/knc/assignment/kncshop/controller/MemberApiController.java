package knc.assignment.kncshop.controller;

import javassist.bytecode.DuplicateMemberException;
import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.dto.MemberDto;
import knc.assignment.kncshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<Member> signup(
            @Valid @RequestBody MemberDto memberDto
            ) throws DuplicateMemberException {
        return ResponseEntity.ok(memberService.signup(memberDto));
    }

    @GetMapping("/member")
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ResponseEntity<Member> getMyMemberInfo() {
        return ResponseEntity.ok(memberService.getMyMemberWithAuthorities().get());
    }

    @GetMapping("/member/{username}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity<Member> getMemberInfo(@PathVariable String username) {
        return ResponseEntity.ok(memberService.getMemberWithAuthorities(username).get());
    }
}

package knc.assignment.kncshop.controller;

import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/admin/members")
    public List<Member> members() {
        return memberService.findAll();
    }

//    @GetMapping("/user/members")
//    public List<Member> membersV2() {
//        return memberService.findAll();
//    }


    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("hello");
    }
}

package knc.assignment.kncshop.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Log4j2
public class MemberController {
    
    @GetMapping("/member/join")
    public String MemberJoinView() {
        return "/member/memberJoin";
    }

    @PostMapping("/member/join")
    public String MemberJoin() {
        log.info("확인사항ㅇㅇㅇ");  
        return "/index";
    }
}

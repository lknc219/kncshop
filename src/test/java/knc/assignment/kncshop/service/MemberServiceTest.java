package knc.assignment.kncshop.service;

import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.repository.MemberRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    EntityManager em;

    public void 회원가입() {
        Member member = new Member();
        member.setName("김남철");

        Long joinId = memberService.join(member);
        em.flush();

        assertEquals(member, memberRepository.findById(joinId));

    }

}
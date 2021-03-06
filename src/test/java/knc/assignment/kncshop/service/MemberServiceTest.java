package knc.assignment.kncshop.service;

import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.Optional;

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

    @Test
    public void 회원가입() throws Exception {
        Member member = new Member();
        member.setMemberName("김남철");

        Long joinId = memberService.join(member);
        em.flush();


        Member findMember = memberRepository.findById(joinId).orElse(new Member());
        assertEquals(member, findMember);

    }

    @Test
    public void findOneWithAuthoritiesByUsernameTest() {
        System.out.println("테스트 시작");
        Optional<Member> findMember = memberRepository.findOneWithAuthoritiesByUsername("admin");
        if(!findMember.isPresent()) {
            System.out.println("테스트 실패");
        }
        Member member = findMember.get();
        System.out.println("member.getMemberId() = " + member.getMemberId());
        System.out.println("member.getUsername() = " + member.getUsername());
        System.out.println("member.getMemberAuthorities() = " + member.getMemberAuthorities());
        System.out.println("테스트 끝");
    }

}
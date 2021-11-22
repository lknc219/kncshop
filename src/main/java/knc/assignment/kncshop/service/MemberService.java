package knc.assignment.kncshop.service;

import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(Member member){
        Member joinMember = memberRepository.save(member);
        return joinMember.getMemberId();
    }

}

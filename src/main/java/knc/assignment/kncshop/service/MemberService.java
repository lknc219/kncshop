package knc.assignment.kncshop.service;

import javassist.bytecode.DuplicateMemberException;
import knc.assignment.kncshop.domain.Authority;
import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.dto.MemberDto;
import knc.assignment.kncshop.repository.MemberRepository;
import knc.assignment.kncshop.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Transactional
    public Member signUp(MemberDto memberDto) throws DuplicateMemberException {
        if (memberRepository.findOneWithAuthoritiesByUsername(memberDto.getUsername()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Member member = Member.builder()
                .username(memberDto.getUsername())
                .password(memberDto.getPassword())
                .nickname(memberDto.getNickName())
                .activated(true)
                .build();

        return memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    public Optional<Member> getUserWithAuthorities(String username) {
        return memberRepository.findOneWithAuthoritiesByUsername(username);
    }

    @Transactional(readOnly = true)
    public Optional<Member> getMyMemberWithAuthorities() {
        return SecurityUtil.getCurrentUsername().flatMap(memberRepository::findOneWithAuthoritiesByUsername);
    }

    public Long join(Member member){
        Member joinMember = memberRepository.save(member);
        return joinMember.getMemberId();
    }

    public List<Member> findAll() {
        List<Member> findAllMember = memberRepository.findAll();

        return findAllMember;
    }


}

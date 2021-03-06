package knc.assignment.kncshop.repository;

import knc.assignment.kncshop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    Optional<Member> findOneWithAuthoritiesByUsername(String username);
}

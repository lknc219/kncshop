package knc.assignment.kncshop.repository;

import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.domain.MemberAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthorityRepository extends JpaRepository<MemberAuthority, Long> {

}

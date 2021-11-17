package knc.assignment.kncshop.repository;

import knc.assignment.kncshop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

//    Member findByName(String name);

}

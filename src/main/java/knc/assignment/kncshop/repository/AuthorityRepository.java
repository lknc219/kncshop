package knc.assignment.kncshop.repository;

import knc.assignment.kncshop.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
}

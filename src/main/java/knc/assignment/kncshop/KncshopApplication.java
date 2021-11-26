package knc.assignment.kncshop;

import knc.assignment.kncshop.domain.Authority;
import knc.assignment.kncshop.domain.Member;
import knc.assignment.kncshop.domain.MemberAuthority;
import knc.assignment.kncshop.repository.AuthorityRepository;
import knc.assignment.kncshop.repository.MemberAuthorityRepository;
import knc.assignment.kncshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@RequiredArgsConstructor
public class KncshopApplication {

	private final MemberRepository memberRepository;
	private final AuthorityRepository authorityRepository;
	private final MemberAuthorityRepository memberAuthorityRepository;

	private static final Logger logger = LoggerFactory.getLogger(KncshopApplication.class);

	@PostConstruct
	public void createDummyData () {
		Authority roleUser = new Authority("ROLE_USER");
		Authority roleAdmin = new Authority("ROLE_ADMIN");
		authorityRepository.save(roleUser);
		authorityRepository.save(roleAdmin);

		Member member1 = new Member("admin","$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi","admin",true);
		Member member2 = new Member("user","$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC","user",true);
		memberRepository.save(member1);
		memberRepository.save(member2);

		memberAuthorityRepository.save(new MemberAuthority(member1, roleUser));
		memberAuthorityRepository.save(new MemberAuthority(member1, roleAdmin));
		memberAuthorityRepository.save(new MemberAuthority(member2, roleUser));
	}

	public static void main(String[] args) {
		SpringApplication.run(KncshopApplication.class, args);
	}

}

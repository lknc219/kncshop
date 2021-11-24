package knc.assignment.kncshop.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String username;

    private String password;

    private String useYn;

    private String email;

    private String phoneNumber;

    private String memberName;

    private String gender;

    private LocalDateTime joinDate;

    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchases;

}

package knc.assignment.kncshop.domain;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    private String username;

    private String password;

    private boolean activated;

    private String useYn;

    private String email;

    private String phoneNumber;

    private String memberName;

    private String nickname;

    private String gender;

    private LocalDateTime joinDate;

    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "member")
    private List<Purchase> purchases;

//    @ManyToMany
//    @JoinTable(
//            name = "member_authority",
//            joinColumns = {@JoinColumn(name = "member_id", referencedColumnName = "member_id")},
//            inverseJoinColumns = {@JoinColumn(name = "authority_name",referencedColumnName = "authority_name")})
//    private Set<Authority> authorities;

    @OneToMany(mappedBy = "member")
    private Set<MemberAuthority> memberAuthorities;

    public Member (String username, String password, String nickname, boolean activated) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.activated = activated;
    }

    public void addMemberAuthorities(MemberAuthority memberAuthority) {
        this.memberAuthorities.add(memberAuthority);
        memberAuthority.setMember(this);
    }

}

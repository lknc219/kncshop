package knc.assignment.kncshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String phoneNumber;

    private String gender;

    private UserType userType;

    @Embedded
    private Address address;

    private LocalDateTime joinDate;

    private LocalDateTime updateDate;

}

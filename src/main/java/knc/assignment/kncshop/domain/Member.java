package knc.assignment.kncshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id @GeneratedValue
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

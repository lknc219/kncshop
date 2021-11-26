package knc.assignment.kncshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import knc.assignment.kncshop.domain.Member;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {

    @NotNull
    private String username;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull
    private String password;

    @NotNull
    private String nickName;


//    public static MemberDto from(Member member) {
//        if(member == null) return null;
//
//        return MemberDto.builder()
//                .username(member.getUsername())
//                .nickName(member.getNickname())
//                .build();
//    }

}

package knc.assignment.kncshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Purchase {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseId;

    private LocalDateTime purchaseDate;

    @Embedded
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseList> purchaseLists;


}

package knc.assignment.kncshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class PurchaseList {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long purchaseListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    private Product products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchaseId")
    private Purchase purchase;

    private int purchasePrice;

}

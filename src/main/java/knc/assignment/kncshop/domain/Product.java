package knc.assignment.kncshop.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    private String productName;

    private int productPrice;

/*
    @OneToOne(fetch = FetchType.LAZY)
    private Category categoryId;
*/

    @OneToMany(mappedBy = "product")
    private List<ProductCategory> productCategories;

    private int productQuantity;

    @OneToMany(mappedBy = "products")
    private List<PurchaseList> purchaseList;

}

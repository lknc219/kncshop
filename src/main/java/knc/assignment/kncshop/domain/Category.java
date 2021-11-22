package knc.assignment.kncshop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter @Setter
@Entity
public class Category {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryCode;

    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<ProductCategory> productCategories;
}

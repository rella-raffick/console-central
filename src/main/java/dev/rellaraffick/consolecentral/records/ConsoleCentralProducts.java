package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@NoArgsConstructor
public class ConsoleCentralProducts {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private String productDescription;
    private Float productPrice;
    private Integer productStock;
    @ManyToOne
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId")
    private ConsoleCentralCategories category;

    public ConsoleCentralProducts(Integer productId, String productName, String productDescription, Float productPrice, Integer productStock, ConsoleCentralCategories category) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.category = category;
    }

}

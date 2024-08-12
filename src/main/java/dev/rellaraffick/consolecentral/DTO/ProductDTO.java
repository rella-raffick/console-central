package dev.rellaraffick.consolecentral.DTO;

import lombok.Data;

@Data
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String productDescription;
    private Float productPrice;
    private Integer productStock;
    private Integer categoryId;


    public ProductDTO(Integer productId, String productName, String productDescription, Float productPrice, Integer productStock, Integer categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productStock = productStock;
        this.categoryId = categoryId;
    }
}

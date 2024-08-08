package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleCentralOrderDetails {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer orderDetailId;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private ConsoleCentralOrders order;
    @ManyToOne
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private ConsoleCentralProducts product;
    private Integer quantity;
    private Float price;
}

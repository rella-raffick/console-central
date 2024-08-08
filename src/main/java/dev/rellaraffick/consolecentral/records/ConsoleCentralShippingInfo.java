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
public class ConsoleCentralShippingInfo {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer shippingId;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "orderId")
    private ConsoleCentralOrders order;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
}

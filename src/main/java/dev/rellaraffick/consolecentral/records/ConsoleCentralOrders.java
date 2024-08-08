package dev.rellaraffick.consolecentral.records;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsoleCentralOrders {
    @jakarta.persistence.Id
    @org.springframework.data.annotation.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private ConsoleCentralUser user;
    private LocalDateTime orderDate;
    private String orderStatus;
    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
    }
}

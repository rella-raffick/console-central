package dev.rellaraffick.consolecentral.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrdersDTO {
    private Integer orderId;
    private Integer userId;
    private LocalDateTime orderDate;
    private String orderStatus;

    public OrdersDTO(Integer orderId, Integer userId, String orderStatus, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderDate = orderDate;
    }
}

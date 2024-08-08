package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralOrderDetails;
import dev.rellaraffick.consolecentral.repositories.OrderDetailsRepository;
import dev.rellaraffick.consolecentral.repositories.OrdersRepository;

public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;
    private final OrdersRepository ordersRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository, OrdersRepository ordersRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
        this.ordersRepository = ordersRepository;
    }

    //TODO: NEED MORE UNDERSTANDING
    public void addProductToOrder(Integer orderId, ConsoleCentralOrderDetails orderDetails) {
        orderDetails.setOrder(ordersRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId)));
        orderDetailsRepository.save(orderDetails);
    }

    public void updateQuantity(Integer orderDetailsId, Integer quantity) {
        ConsoleCentralOrderDetails existingOrderDetails = orderDetailsRepository.findById(orderDetailsId)
                .orElseThrow(() -> new RuntimeException("Order Details not found with id: " + orderDetailsId));
        existingOrderDetails.setQuantity(quantity);
        orderDetailsRepository.save(existingOrderDetails);
    }

    public void removeProductFromOrder(Integer orderDetailsId) {
        orderDetailsRepository.deleteById(orderDetailsId);
    }

}

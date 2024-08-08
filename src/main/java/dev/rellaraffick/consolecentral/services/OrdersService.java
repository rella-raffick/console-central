package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralOrders;
import dev.rellaraffick.consolecentral.repositories.OrdersRepository;

public class OrdersService {
    private final OrdersRepository orderRepository;

    public OrdersService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void getOrders() {
        orderRepository.findAll();
    }

    public void getOrderById(Integer orderId) {
        orderRepository.findById(orderId);
    }

    public void createOrder(ConsoleCentralOrders order) {
        orderRepository.save(order);
    }

    public void updateOrder(int id, ConsoleCentralOrders order) {
        ConsoleCentralOrders existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder != null) {
            existingOrder.setOrderDate(order.getOrderDate());
            existingOrder.setOrderStatus(order.getOrderStatus());
            existingOrder.setUser(order.getUser());
            orderRepository.save(existingOrder);
        }
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }


}

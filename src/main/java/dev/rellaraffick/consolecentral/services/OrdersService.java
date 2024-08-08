package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralOrders;
import dev.rellaraffick.consolecentral.repositories.OrdersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {
    private final OrdersRepository orderRepository;

    public OrdersService(OrdersRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional(readOnly = true)
    public List<ConsoleCentralOrders> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ConsoleCentralOrders getOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    @Transactional(readOnly = true)
    public List<ConsoleCentralOrders> getAllOrdersByUserId(Integer userId) {
       return orderRepository.findAllByUserUserId(userId);
    }

    @Transactional
    public ConsoleCentralOrders createOrder(ConsoleCentralOrders order) {
        return orderRepository.save(order);
    }

    @Transactional
    public ConsoleCentralOrders updateOrderStatus(Integer orderId, String status) {
        ConsoleCentralOrders existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        existingOrder.setOrderStatus(status);
        return orderRepository.save(existingOrder);
    }

    @Transactional
    public boolean deleteOrder(Integer orderId) {
        try {
            orderRepository.deleteById(orderId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

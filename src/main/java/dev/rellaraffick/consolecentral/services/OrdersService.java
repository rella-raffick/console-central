package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.DTO.OrdersDTO;
import dev.rellaraffick.consolecentral.records.ConsoleCentralOrders;
import dev.rellaraffick.consolecentral.records.ConsoleCentralUser;
import dev.rellaraffick.consolecentral.repositories.OrdersRepository;
import dev.rellaraffick.consolecentral.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrdersService {
    private final OrdersRepository orderRepository;
    private final UserRepository usersRepository;

    public OrdersService(OrdersRepository orderRepository, UserRepository usersRepository) {
        this.orderRepository = orderRepository;
        this.usersRepository = usersRepository;
    }

    @Transactional(readOnly = true)
    public List<OrdersDTO> getAllOrders(Integer userId) {
        return orderRepository.findAllSimpleOrdersByUserId(userId);
    }

    @Transactional(readOnly = true)
    public OrdersDTO getOrderById(Integer orderId) {
        return orderRepository.findOrderDTOById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }

    @Transactional
    public OrdersDTO createOrder(ConsoleCentralOrders order, Integer userId) {
        ConsoleCentralUser user = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);
        orderRepository.save(order);
        return new OrdersDTO(order.getOrderId(), order.getUser().getUserId(), order.getOrderStatus(), order.getOrderDate());
    }

    @Transactional
    public OrdersDTO updateOrderStatus(Integer orderId, String status) {
        ConsoleCentralOrders existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        existingOrder.setOrderStatus(status);
        existingOrder.setUser(existingOrder.getUser());
        orderRepository.save(existingOrder);
        return new OrdersDTO(existingOrder.getOrderId(), existingOrder.getUser().getUserId(), existingOrder.getOrderStatus(), existingOrder.getOrderDate());
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

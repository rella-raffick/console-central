package dev.rellaraffick.consolecentral.services;

import dev.rellaraffick.consolecentral.records.ConsoleCentralOrderDetails;
import dev.rellaraffick.consolecentral.repositories.OrderDetailsRepository;

public class OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    public void getOrderDetails() {
        orderDetailsRepository.findAll();
    }

    public void getOrderDetailById(Integer orderDetailId) {
        orderDetailsRepository.findById(orderDetailId);
    }

    public void createOrderDetail(ConsoleCentralOrderDetails orderDetail) {
        orderDetailsRepository.save(orderDetail);
    }

    public void updateOrderDetail(int id, ConsoleCentralOrderDetails orderDetail) {
        ConsoleCentralOrderDetails existingOrderDetail = orderDetailsRepository.findById(id).orElse(null);
        if (existingOrderDetail != null) {
            existingOrderDetail.setOrder(orderDetail.getOrder());
            existingOrderDetail.setProduct(orderDetail.getProduct());
            existingOrderDetail.setQuantity(orderDetail.getQuantity());
            existingOrderDetail.setPrice(orderDetail.getPrice());
            existingOrderDetail.setOrder(orderDetail.getOrder());
            existingOrderDetail.setProduct(orderDetail.getProduct());
            orderDetailsRepository.save(existingOrderDetail);
        }
    }

    public void deleteOrderDetail(int id) {
        orderDetailsRepository.deleteById(id);
    }

}

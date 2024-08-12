package dev.rellaraffick.consolecentral.controllers;

import dev.rellaraffick.consolecentral.DTO.OrdersDTO;
import dev.rellaraffick.consolecentral.records.ConsoleCentralOrders;
import dev.rellaraffick.consolecentral.services.OrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {

    private final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping("/all/{userId}")
    List<OrdersDTO> findAllOrdersByUser(@PathVariable Integer userId){
        return ordersService.getAllOrders(userId);
    }

    @GetMapping("/{orderId}")
    OrdersDTO findOrderById(@PathVariable Integer orderId){
        return ordersService.getOrderById(orderId);
    }

    @PostMapping("/create/{userId}")
    OrdersDTO createOrder(@RequestBody ConsoleCentralOrders order, @PathVariable Integer userId){
        return ordersService.createOrder(order, userId);
    }

    @PatchMapping("/update/{orderId}")
    OrdersDTO updateOrderStatus(@PathVariable Integer orderId, @RequestBody ConsoleCentralOrders order){
        return ordersService.updateOrderStatus(orderId, order.getOrderStatus());
    }

    @DeleteMapping("/delete/{orderId}")
    void deleteOrder(@PathVariable Integer orderId){
        ordersService.deleteOrder(orderId);
    }
}

package dev.rellaraffick.consolecentral.repositories;

import dev.rellaraffick.consolecentral.DTO.OrdersDTO;
import dev.rellaraffick.consolecentral.records.ConsoleCentralOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrdersRepository extends JpaRepository<ConsoleCentralOrders, Integer> {
    @Query("SELECT new dev.rellaraffick.consolecentral.DTO.OrdersDTO(o.orderId, u.userId, o.orderStatus, o.orderDate) FROM ConsoleCentralOrders o JOIN o.user u WHERE u.userId = :userId")
    List<OrdersDTO> findAllSimpleOrdersByUserId(@Param("userId") Integer userId);
    @Query("SELECT new dev.rellaraffick.consolecentral.DTO.OrdersDTO(o.orderId, u.userId, o.orderStatus, o.orderDate) FROM ConsoleCentralOrders o JOIN o.user u WHERE o.orderId = :orderId")
    Optional<OrdersDTO> findOrderDTOById(@Param("orderId") Integer orderId);
}

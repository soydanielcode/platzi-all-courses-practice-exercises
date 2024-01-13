package com.platzi.pizza.persistence.repository;

import com.platzi.pizza.persistence.entity.OrderEntity;
import com.platzi.pizza.persistence.entity.PizzaEntity;
import com.platzi.pizza.persistence.proyections.OrderSummary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends ListCrudRepository<OrderEntity, Integer>{
    List<OrderEntity> findAllByDateAfter(LocalDateTime today);
    List<OrderEntity> findAllByMethodInOrderByDate(List<String> method);

    @Query(value = "SELECT * FROM pizza_order where id_customer = :id", nativeQuery = true)
    List<OrderEntity> findCustomerByOrders(@Param("id") String idCustomer);
    
    @Query(value =
            "SELECT  po.ID_ORDER AS idOrder, cu.NAME AS customerName, "  +
            "   po.date AS orderDate, po.TOTAL AS orderTotal, "  +
            "   GROUP_CONCAT(p.name) AS pizzaName "  +
            "FROM  pizza_order po "  +
            "  INNER JOIN customer cu ON po.ID_CUSTOMER = cu.ID_CUSTOMER "  +
            "  INNER JOIN ORDER_ITEM oi ON po.ID_ORDER = oi.ID_ORDER "  +
            "  INNER JOIN PIZZA p ON oi.ID_PIZZA = p.ID_PIZZA "  +
            "WHERE po.ID_ORDER = :orderId "  +
            "GROUP BY po.ID_ORDER , cu.NAME, po.date, po.TOTAL", nativeQuery = true)
    OrderSummary findSummary(@Param("orderId") Integer orderId);

    @Procedure(value = "take_random_pizza_order", outputParameterName = "order_taken")
    boolean saveRandomOrder(@Param("id_customer") String idCustomer, @Param("method") String method);
}

package pja.tpo.ecommerceshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pja.tpo.ecommerceshop.DTOs.OrderSummaryDTO;
import pja.tpo.ecommerceshop.Model.Order;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findOrderById(Long id);
    void deleteByClientId(Long id);

    @Query("SELECT new pja.tpo.ecommerceshop.DTOs.OrderSummaryDTO(o.id, c.firstName, c.lastName, o.orderDate, o.totalAmount, o.status) " +
            "FROM Order o JOIN o.client c")
    List<OrderSummaryDTO> findAllOrderDTOs();

    @Query("SELECT new pja.tpo.ecommerceshop.DTOs.OrderSummaryDTO(o.id, c.firstName, c.lastName, o.orderDate, o.totalAmount, o.status) " +
            "FROM Order o JOIN o.client c WHERE o.id = :orderId")
    OrderSummaryDTO findOrderDTOById(@Param("orderId") Long orderId);


}
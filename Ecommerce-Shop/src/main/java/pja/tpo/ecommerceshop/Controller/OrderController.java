package pja.tpo.ecommerceshop.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pja.tpo.ecommerceshop.DTOs.OrderSummaryDTO;
import pja.tpo.ecommerceshop.Model.Order;
import pja.tpo.ecommerceshop.Service.OrderService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/orders")
public class OrderController {

    public final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<OrderSummaryDTO>> getAllOrderDTOs() {
        List<Order> orders = orderService.getAllOrders();
        List<OrderSummaryDTO> orderDTOs = orders
                .stream()
                .map(o -> orderService.getOrderSummary(o.getId()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(orderDTOs);
    }

   @GetMapping("/dto/{id}")
    public ResponseEntity<OrderSummaryDTO> getOrderDTOById(@PathVariable Long id) {

        Order orders = orderService.getOrderById(id).orElseThrow(() -> new RuntimeException("Order not found"));
        OrderSummaryDTO orderSummaryDTO = orderService.getOrderSummary(orders.getId());

        return ResponseEntity.ok(orderSummaryDTO);

    }


}

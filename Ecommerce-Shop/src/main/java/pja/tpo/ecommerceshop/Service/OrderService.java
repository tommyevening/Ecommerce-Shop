package pja.tpo.ecommerceshop.Service;


import org.springframework.stereotype.Service;
import pja.tpo.ecommerceshop.Model.Order;
import pja.tpo.ecommerceshop.Repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}

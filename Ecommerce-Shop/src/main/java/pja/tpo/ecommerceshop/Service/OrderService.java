package pja.tpo.ecommerceshop.Service;


import org.springframework.stereotype.Service;
import pja.tpo.ecommerceshop.DTOs.CategoryDTO;
import pja.tpo.ecommerceshop.DTOs.OrderItemDTO;
import pja.tpo.ecommerceshop.DTOs.OrderSummaryDTO;
import pja.tpo.ecommerceshop.DTOs.ProductGetDTO;
import pja.tpo.ecommerceshop.Model.Category;
import pja.tpo.ecommerceshop.Model.Order;
import pja.tpo.ecommerceshop.Model.OrderItem;
import pja.tpo.ecommerceshop.Model.Product;
import pja.tpo.ecommerceshop.Repository.OrderItemRepository;
import pja.tpo.ecommerceshop.Repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<OrderSummaryDTO> getAllOrderDTOs() {
        return orderRepository.findAllOrderDTOs();
    }

    public OrderSummaryDTO getOrderDTOById(Long id) {
        return orderRepository.findOrderDTOById(id);
    }

    public OrderSummaryDTO getOrderSummary(Long orderID){

        Order order = orderRepository.findOrderById(orderID).get();
        List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderID);

        OrderSummaryDTO orderSummary = new OrderSummaryDTO();
        orderSummary.setId(order.getId());
        orderSummary.setClientFirstName(order.getClient().getFirstName());
        orderSummary.setClientLastName(order.getClient().getLastName());
        orderSummary.setOrderDate(order.getOrderDate());
        orderSummary.setTotalAmount(order.getTotalAmount());
        orderSummary.setStatus(order.getStatus());

        List<OrderItemDTO> orderItemDTOs = new ArrayList<>();

        for (OrderItem item : orderItems) {

            ProductGetDTO productGetDTO = toProductGetDTO(item.getProduct());

            OrderItemDTO orderItemDTO = new OrderItemDTO();
            orderItemDTO.setId(item.getId());
            orderItemDTO.setOrderId(item.getOrder().getId());
            orderItemDTO.setProductId(item.getProduct().getId());
            orderItemDTO.setQuantity(item.getQuantity());
            orderItemDTO.setPriceAtPurchase(item.getPriceAtPurchase());
            orderItemDTO.setProduct(productGetDTO);
            orderItemDTOs.add(orderItemDTO);
        }

        orderSummary.setOrderItems(orderItemDTOs);

        return orderSummary;
    }

    public ProductGetDTO toProductGetDTO(Product product) {
        Category category = product.getCategory();
        CategoryDTO categoryDTO = new CategoryDTO(category.getId(), category.getName(), category.getDescription());
        return new ProductGetDTO(product.getName(), categoryDTO, product.getPrice());
    }
}

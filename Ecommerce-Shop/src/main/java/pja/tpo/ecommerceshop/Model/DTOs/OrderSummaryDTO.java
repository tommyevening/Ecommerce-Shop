package pja.tpo.ecommerceshop.Model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderSummaryDTO {

    public OrderSummaryDTO(Long id, String clientFirstName, String clientLastName, LocalDateTime orderDate, Double totalAmount, String status) {
        this.id = id;
        this.clientFirstName = clientFirstName;
        this.clientLastName = clientLastName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }
    private Long id;
    private String clientFirstName;
    private String clientLastName;
    private LocalDateTime orderDate;
    private List<OrderItemDTO> orderItems = new ArrayList<>();
    private Double totalAmount;
    private String status;
}

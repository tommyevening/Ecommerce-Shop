package pja.tpo.ecommerceshop.Model.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderSummaryDTO {
    private Long id;
    private String clientFirstName;
    private String clientLastName;
    private LocalDateTime orderDate;
    private Double totalAmount;
    private String status;
}

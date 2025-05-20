package pja.tpo.ecommerceshop.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pja.tpo.ecommerceshop.DTOs.ProductGetDTO;
import pja.tpo.ecommerceshop.Model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT new pja.tpo.ecommerceshop.DTOs.ProductGetDTO(p.name, p.category, p.price) FROM Product p")
    List<ProductGetDTO> findAllProducts();
}

package pja.tpo.ecommerceshop.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pja.tpo.ecommerceshop.DTOs.ProductGetDTO;
import pja.tpo.ecommerceshop.Service.ProductService;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

   /* @GetMapping
    public ResponseEntity<List<ProductGetDTO>> getAllProducts() {
        List<ProductGetDTO> products = productService.getAllProducts();

        if (products.isEmpty()) return ResponseEntity.noContent().build();

        return ResponseEntity.ok(products);
    }*/
}

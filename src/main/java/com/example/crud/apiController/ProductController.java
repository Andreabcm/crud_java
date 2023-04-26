package com.example.crud.apiController;

import com.example.crud.domain.models.Product;
import com.example.crud.domain.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


        @GetMapping("/product")
        public ResponseEntity<List<Product>> getAll() {
            return ResponseEntity.ok(this.productService.findAll());
        }

        @GetMapping("/product/{id}")
        public ResponseEntity<Product> getById(@PathVariable Long id) {
            return ResponseEntity.ok(this.productService.findById(id));
        }

        @PostMapping("/products")
        public ResponseEntity<Product> create(@RequestBody Product product) {
            return ResponseEntity.ok(this.productService.create(product));
        }

        @DeleteMapping("/product/{id}")
        public void deleteById(@PathVariable Long id) {
        this.productService.deleteById(id);
        }

}

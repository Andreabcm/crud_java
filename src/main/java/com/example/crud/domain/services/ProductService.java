package com.example.crud.domain.services;

import com.example.crud.domain.models.Product;
import com.example.crud.infrastructure.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findById(Long id) {
        var productOptional = this.productRepository.findById(id);
        //NO EXISTE EL PRODUCT
        if (productOptional.isEmpty()) throw new RuntimeException("Este post con el id " + id + " no existe");
        //EXISTE EL PRODUCT
        return productOptional.get();
    }

    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    public void deleteById(Long productId) {
        this.productRepository.deleteById(productId);
    }


}

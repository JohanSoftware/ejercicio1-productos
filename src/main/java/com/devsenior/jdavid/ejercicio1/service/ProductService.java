package com.devsenior.jdavid.ejercicio1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.jdavid.ejercicio1.model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new Product(nextId++, "Laptop", 1200.00));
        products.add(new Product(nextId++, "Mouse", 25.00));
        products.add(new Product(nextId++, "Teclado Mecánico", 90.00));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }
}

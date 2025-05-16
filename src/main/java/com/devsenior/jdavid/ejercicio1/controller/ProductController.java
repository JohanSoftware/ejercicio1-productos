package com.devsenior.jdavid.ejercicio1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.jdavid.ejercicio1.model.Product;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private static List<Product> products = new ArrayList<>();
    private static Long nextId = 1L;

    static {
        products.add(new Product(nextId++, "Laptop", 1200.00));
        products.add(new Product(nextId++, "Mouse", 25.00));
        products.add(new Product(nextId++, "Teclado Mecánico", 90.00));
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @PostMapping 
    public Product addProduct(@RequestBody Product newProduct) {
        newProduct.setId(nextId++);
        products.add(newProduct);
        return newProduct;
    }


}

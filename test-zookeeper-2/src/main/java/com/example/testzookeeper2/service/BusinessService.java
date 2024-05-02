package com.example.testzookeeper2.service;

import com.example.testzookeeper2.bean.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {
    public List<Product> getProducts() {
        List<Product> productList = new ArrayList<>();
        Product product1 = new Product(1, "product-A", "AAAAA", LocalDateTime.of(2024, 5, 1, 12, 30, 45));
        Product product2 = new Product(2, "product-B", "BBBBB", LocalDateTime.of(2024, 5, 1, 12, 30, 45));
        Product product3 = new Product(3, "product-C", "CCCCC", LocalDateTime.of(2024, 5, 1, 12, 30, 45));

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        return productList;
    }
}

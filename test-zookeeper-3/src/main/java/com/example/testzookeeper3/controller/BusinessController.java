package com.example.testzookeeper3.controller;

import com.example.testzookeeper3.bean.Product;
import com.example.testzookeeper3.service.BusinessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BusinessController {

    private final Logger logger = LoggerFactory.getLogger(BusinessController.class);

    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        List<Product> productList = businessService.getProducts();
        logger.info("returned products:{}", productList);
        return productList;
    }
}
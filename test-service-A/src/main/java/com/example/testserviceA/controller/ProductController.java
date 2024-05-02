package com.example.testserviceA.controller;

import com.example.testserviceA.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class ProductController {

    private final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product-names")
    public List<String> getProductNames() throws Exception {
        List<String> productNameList = productService.getProductNames();
        logger.info("returned products:{}", productNameList);
        return productNameList;
    }
}
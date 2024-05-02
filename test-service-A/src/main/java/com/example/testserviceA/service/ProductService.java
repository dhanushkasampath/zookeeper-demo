package com.example.testserviceA.service;

import com.example.testserviceA.bean.Instance;
import com.example.testserviceA.bean.Product;
import com.example.testserviceA.util.CustomServiceDiscovery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final RemoteCallService remoteCallService;
    private final CustomServiceDiscovery customServiceDiscovery;

    public ProductService(RemoteCallService remoteCallService, CustomServiceDiscovery customServiceDiscovery) {
        this.remoteCallService = remoteCallService;
        this.customServiceDiscovery = customServiceDiscovery;
    }

    public List<String> getProductNames() throws Exception {

        Instance availableInstance = customServiceDiscovery.getAvailableInstance("test-service-B");
        List<Product> remoteProductList = remoteCallService.getRemoteProducts(availableInstance.getHost(), availableInstance.getPort());
        return remoteProductList.stream()
            .map(Product::getName)
            .toList();
    }
}

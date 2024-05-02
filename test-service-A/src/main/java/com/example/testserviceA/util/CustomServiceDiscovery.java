package com.example.testserviceA.util;

import com.example.testserviceA.bean.Instance;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.zookeeper.discovery.ZookeeperInstance;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomServiceDiscovery {
    private final Logger logger = LoggerFactory.getLogger(CustomServiceDiscovery.class);

    private static final String ZOOKEEPER_CONNECTION_STRING = "localhost:2181";

    public Instance getAvailableInstance(String serviceName) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(
                ZOOKEEPER_CONNECTION_STRING,
                new ExponentialBackoffRetry(1000, 3)
        );
        curatorFramework.start();

        ServiceDiscovery<ZookeeperInstance> serviceDiscovery = ServiceDiscoveryBuilder.builder(ZookeeperInstance.class)
                .client(curatorFramework)
                .basePath("/services")
                .serializer(new JsonInstanceSerializer<>(ZookeeperInstance.class))
                .build();
        serviceDiscovery.start();

        Collection<ServiceInstance<ZookeeperInstance>> instances = serviceDiscovery.queryForInstances(serviceName);

        // Implement round-robin selection using AtomicInteger
        AtomicInteger counter = new AtomicInteger(0);

        // Choose an instance using round-robin strategy
        ServiceInstance<ZookeeperInstance> chosenInstance = instances.stream().toList().get(counter.getAndIncrement() % instances.size());

        String host = "";
        String port = "";
        // Print the chosen instance
        if (chosenInstance != null) {
            host = chosenInstance.getAddress();
            port = String.valueOf(chosenInstance.getPort());
            logger.info("Chosen instance for {}: {}:{}", serviceName, host, port);
        } else {
            logger.info("No instances of {} found.", serviceName);
        }

        // Don't forget to close resources when done
        serviceDiscovery.close();
        curatorFramework.close();

        return new Instance(host, port);
    }
}

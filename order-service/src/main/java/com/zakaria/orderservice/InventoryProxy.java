package com.zakaria.orderservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "inventory-service",url="http://localhost:8082/")
@FeignClient(name = "inventory-service")

public interface InventoryProxy {

    @GetMapping("/api/inventory/{code}")
    boolean IsInStock(@PathVariable String code);
}

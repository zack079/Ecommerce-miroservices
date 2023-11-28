package com.zakaria.inventoryservice.controller;
import org.springframework.core.env.Environment;

import com.zakaria.inventoryservice.model.Inventory;
import com.zakaria.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private Environment environment;

    @GetMapping("/{code}")
    public boolean IsInStock(@PathVariable String code){
        System.out.println("this server was called ||"+new Date()+" || port :"+environment.getProperty("local.server.port"));
        return inventoryService.IsInStock(code);
    }

}

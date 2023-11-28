package com.zakaria.inventoryservice.service;

import com.zakaria.inventoryservice.model.Inventory;
import com.zakaria.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    public boolean IsInStock(String code){
        return inventoryRepository.findByCode(code).isPresent();
    }

}

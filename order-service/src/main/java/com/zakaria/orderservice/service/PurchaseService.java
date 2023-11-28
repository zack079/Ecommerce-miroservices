package com.zakaria.orderservice.service;


import com.zakaria.orderservice.InventoryProxy;
import com.zakaria.orderservice.model.Purchase;
import com.zakaria.orderservice.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private InventoryProxy inventoryProxy;
    public Purchase createPurchase(Purchase purchase) {
        //make a purchase when the product is in inventory
        if(inventoryProxy.IsInStock(purchase.getCode())){

            return purchaseRepository.save(purchase);

        }
        else
            return null;
    }

    public List<Purchase> getAllPurchases() {
        return purchaseRepository.findAll();
    }


}

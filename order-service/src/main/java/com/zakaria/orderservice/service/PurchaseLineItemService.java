package com.zakaria.orderservice.service;


import com.zakaria.orderservice.model.PurchaseLineItem;
import com.zakaria.orderservice.repository.PurchaseItemLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseLineItemService {

    @Autowired
    private PurchaseItemLineRepository purchaseLineItemRepository;
    public PurchaseLineItem createPurchaseLineItem(PurchaseLineItem purchaseLineItem) {
        return purchaseLineItemRepository.save(purchaseLineItem);
    }

    public List<PurchaseLineItem> getAllPurchaseLineItem() {
        return purchaseLineItemRepository.findAll();
    }
}

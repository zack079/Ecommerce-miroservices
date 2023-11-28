package com.zakaria.orderservice.controller;

import com.zakaria.orderservice.model.PurchaseLineItem;
import com.zakaria.orderservice.service.PurchaseLineItemService;
import com.zakaria.orderservice.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchaseLineItem")
public class PurchaseLineItemController {


    @Autowired
    private PurchaseLineItemService purchaseLineItemServiceService;
    @PostMapping
    public ResponseEntity<PurchaseLineItem> createPurchaseLineItemService(@RequestBody PurchaseLineItem purchaseLineItem){
        PurchaseLineItem returned_purchaseLineItem =purchaseLineItemServiceService.createPurchaseLineItem(purchaseLineItem);

        if(returned_purchaseLineItem !=null){
            return new ResponseEntity<>(returned_purchaseLineItem, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<List<PurchaseLineItem>> getAllPurchaseLineItem(){
        return new ResponseEntity<>(purchaseLineItemServiceService.getAllPurchaseLineItem(),HttpStatus.OK);
    }

}

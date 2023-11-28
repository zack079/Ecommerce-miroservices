package com.zakaria.orderservice.controller;

import com.zakaria.orderservice.model.Purchase;
import com.zakaria.orderservice.service.PurchaseService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;
    @PostMapping
    @CircuitBreaker(name="inventory",fallbackMethod = "fallBackResponse")
    public ResponseEntity<?> createPurchase(@RequestBody Purchase purchase){
        System.out.println("the create purchase method is called");
        Purchase returned_purchase =purchaseService.createPurchase(purchase);

        if(returned_purchase !=null){
            return new ResponseEntity<>(returned_purchase, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Product not found",HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchases(){
        return new ResponseEntity<>(purchaseService.getAllPurchases(),HttpStatus.OK);
    }

    public ResponseEntity<?> fallBackResponse(Purchase purchase, Exception e){
        System.out.println("the fall back is being called");
        return  new ResponseEntity<>("Oops! please try again later",HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
}

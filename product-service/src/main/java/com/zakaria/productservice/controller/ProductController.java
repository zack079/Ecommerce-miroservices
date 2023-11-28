package com.zakaria.productservice.controller;

import com.zakaria.productservice.model.Product;
import com.zakaria.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private Environment environment;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product returned_product=productService.createProduct(product);

        if(returned_product!=null){
            return new ResponseEntity<>(returned_product,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct(){
        System.out.println("this server was called ||"+new Date()+" || port :"+environment.getProperty("local.server.port"));

        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

}

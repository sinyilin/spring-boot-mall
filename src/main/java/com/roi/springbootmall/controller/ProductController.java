package com.roi.springbootmall.controller;

import com.roi.springbootmall.model.Product;
import com.roi.springbootmall.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product")
@Tag(name = "產品Product API", description = "產品Product CRUD API")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Operation(summary = "查詢單一產品資訊")
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<Product> getProductById (@PathVariable Integer productId){
        Product product  = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

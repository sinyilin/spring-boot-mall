package com.roi.springbootmall.controller;

import com.roi.springbootmall.dto.ProductRequest;
import com.roi.springbootmall.model.Product;
import com.roi.springbootmall.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


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
        System.out.println(product.getLastModifiedDate());
        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "新增單一產品資訊")
    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct (@RequestBody  @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);

        Product product  = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
}

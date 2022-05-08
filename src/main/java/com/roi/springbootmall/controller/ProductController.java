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
import java.util.List;


@RestController
@RequestMapping("/product")
@Tag(name = "產品Product API", description = "產品Product CRUD API")
public class ProductController {

    @Autowired
    private ProductService productService;


    @GetMapping("products")
    public ResponseEntity<List<Product>> getProductList(){
        List<Product> productList = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }



    @Operation(summary = "查詢單一產品資訊")
    @GetMapping("/product/{productId}")
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
    @PostMapping("/product")
    public ResponseEntity<Product> createProduct (@RequestBody  @Valid ProductRequest productRequest){
        Integer productId = productService.createProduct(productRequest);

        Product product  = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Operation(summary = "更新單一產品資訊")
    @PutMapping("/{productId}")
    public ResponseEntity<Product> updateProduct (@PathVariable Integer productId ,
            @RequestBody @Valid ProductRequest productRequest){
        
        // 檢查product 是否存在
        Product product  = productService.getProductById(productId);
        if (product == null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        productService.updateProduct(productId, productRequest);
        product  = productService.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(product);

    }

    @Operation(summary = "刪除單一產品資訊")
    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct (@PathVariable Integer productId){
        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); //204

    }
}

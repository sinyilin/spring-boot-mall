package com.roi.springbootmall.service;

import com.roi.springbootmall.dto.ProductRequest;
import com.roi.springbootmall.model.Product;

public interface ProductService {

    Product getProductById (Integer productId);


    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}

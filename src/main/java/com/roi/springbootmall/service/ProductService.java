package com.roi.springbootmall.service;

import com.roi.springbootmall.constant.ProductCategory;
import com.roi.springbootmall.dto.ProductRequest;
import com.roi.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}

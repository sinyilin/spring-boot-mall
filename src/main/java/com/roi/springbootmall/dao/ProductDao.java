package com.roi.springbootmall.dao;

import com.roi.springbootmall.constant.ProductCategory;
import com.roi.springbootmall.dto.ProductRequest;
import com.roi.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Product getProductById (Integer productId);

    Integer createOne(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteById(Integer productId);

    List<Product> getProducts(ProductCategory category, String search);
}

package com.roi.springbootmall.dao;

import com.roi.springbootmall.dto.ProductRequest;
import com.roi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);

    Integer createOne(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteById(Integer productId);
}

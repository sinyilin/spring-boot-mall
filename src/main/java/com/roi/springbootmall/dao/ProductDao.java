package com.roi.springbootmall.dao;

import com.roi.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);
}

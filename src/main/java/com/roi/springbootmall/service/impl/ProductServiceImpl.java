package com.roi.springbootmall.service.impl;

import com.roi.springbootmall.dao.ProductDao;
import com.roi.springbootmall.model.Product;
import com.roi.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}

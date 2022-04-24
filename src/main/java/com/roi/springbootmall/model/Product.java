package com.roi.springbootmall.model;

import com.roi.springbootmall.constant.ProductCategory;
import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private int productId;
    private String productName;
    private ProductCategory category;
    private String imageUrl;
    private int price;
    private int stock;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;
}

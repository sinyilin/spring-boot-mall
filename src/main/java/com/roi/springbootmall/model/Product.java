package com.roi.springbootmall.model;

import lombok.Data;

import java.util.Date;

@Data
public class Product {
    private int productId;
    private String productName;
    private String category;
    private String imageUrl;
    private int price;
    private int stock;
    private String description;
    private Date createdDate;
    private Date lastModifiedDate;
}

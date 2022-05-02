package com.roi.springbootmall.constant;

public class TestConstantExample {
    public static void main(String[] args) {
        ProductCategory category = ProductCategory.CAR;
        System.out.println(category.name());

        String s =  "FOOD";
        ProductCategory category1 =  ProductCategory.valueOf(s);

        System.currentTimeMillis(); // 取得當前timestamp
    }
}

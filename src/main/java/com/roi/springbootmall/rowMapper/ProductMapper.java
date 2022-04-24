package com.roi.springbootmall.rowMapper;

import com.roi.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {

        // 上面的Product 表示要將資料庫中查到的數據轉換成哪一種類型的JAVA object
        // ResultSet 存放從資料庫中查到的數據

        Product product = new Product();
        // 下面的欄位與SQL 的SELECT 欄位要一致，是填DB欄位名稱
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setCategory(resultSet.getString("category"));
        product.setImageUrl(resultSet.getString("image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("image_url"));
        product.setCreatedDate(resultSet.getDate("created_date"));
        product.setLastModifiedDate(resultSet.getDate("last_modified_date"));

        //另一種做法，用位數去取值，風險是當SQL的值選出欄位順序調換時 就會取得錯誤的值
//        student.setId(resultSet.getInt(1)); //取得SELECT SQL中第一個值，這裡指的是id

        // resultSet 取得類型
        // DB > JAVA > resultSet
        // INT > Integer > getInt
        // VARCHAR > String >getString
        // BIGINT > Long > getLong
        // DOUBLE >  Double > getDouble
        // Float > Float > get Float
        // BOOLEAN > boolean > getBoolean
        // TimeStamp > Date > getTimeStamp


        return product;

    }
}

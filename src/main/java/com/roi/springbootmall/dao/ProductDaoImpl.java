package com.roi.springbootmall.dao;

import com.roi.springbootmall.model.Product;
import com.roi.springbootmall.rowMapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public Product getProductById(Integer productId) {

        String sql =
                "SELECT product_id,product_name, category, image_url, price, stock, description, created_date, last_modified_date " +
                "FROM product " +
                "WHERE product_id = :productId";


        Map<String, Object> map = new HashMap<>();
        map.put("productId", productId);

        // 3th param is 返回值
        List<Product> productList = namedParameterJdbcTemplate.query(sql, map, new ProductMapper());

        if(productList.size()>0){
            return productList.get(0);
        }else {
            return null;
        }
    }
}

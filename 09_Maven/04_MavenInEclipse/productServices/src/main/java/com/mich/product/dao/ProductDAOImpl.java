package com.mich.product.dao;

import com.mich.product.dto.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO{

    //Como no usamos BD, usamos colecciones

    Map<Integer, Product> productMap = new HashMap<>();

    @Override
    public void create(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product read(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(int id) {

    }
}

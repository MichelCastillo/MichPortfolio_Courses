package com.mich.product.bo;

import com.mich.product.dto.Product;

public interface ProductBO {

    void create(Product product);

    Product findProduct(int id);
}

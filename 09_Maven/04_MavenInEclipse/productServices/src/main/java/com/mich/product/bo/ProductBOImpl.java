package com.mich.product.bo;

import com.mich.product.dao.ProductDAO;
import com.mich.product.dao.ProductDAOImpl;
import com.mich.product.dto.Product;

public class ProductBOImpl implements ProductBO{

    private static ProductDAO dao = new ProductDAOImpl();

    @Override
    public void create(Product product) {
        dao.create(product);
    }

    @Override
    public Product findProduct(int id) {
        return dao.read(id);
    }
}

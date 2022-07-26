package com.mich.product.dao;

import com.mich.product.dto.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductDAOImplTest {

    ProductDAO dao = new ProductDAOImpl();

    @Test
    public void createShouldCreateAProduct(){

        Product product = new Product();
        product.setId(1);
        product.setName("IPhone");
        product.setDescription("Perfect");
        product.setPrice(800);

        dao.create(product);

        //Chequeamos el test
        assertNotNull(dao.read(1));
        assertEquals(product.getName(), dao.read(1).getName());

    }

}
package com.inventory.app;

import com.inventory.dao.ProductDAO;
import com.inventory.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        dao.addProduct(new Product("Laptop", "Electronics", 55000, 5));
        dao.addProduct(new Product("Mouse", "Electronics", 500, 20));
        dao.addProduct(new Product("Keyboard", "Electronics", 800, 15));
        dao.addProduct(new Product("Chair", "Furniture", 3000, 10));
        dao.addProduct(new Product("Table", "Furniture", 7000, 7));

        System.out.println("Products inserted successfully");
    }
}
package com.inventory.app;

import com.inventory.dao.ProductHQLDAO;

public class HQLMainApp {

    public static void main(String[] args) {

        ProductHQLDAO dao = new ProductHQLDAO();

        System.out.println("---- Price Ascending ----");
        dao.sortByPriceAsc();

        System.out.println("---- Price Descending ----");
        dao.sortByPriceDesc();

        System.out.println("---- Pagination (First 3) ----");
        dao.pagination(0, 3);

        System.out.println("---- Pagination (Next 3) ----");
        dao.pagination(3, 3);

        System.out.println("---- Aggregate Functions ----");
        dao.aggregateFunctions();
    }
}
package com.inventory.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class ProductHQLDAO {

    public void sortByPriceAsc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery(
                "from Product p order by p.price asc", Product.class);
        q.list().forEach(p -> 
            System.out.println(p.getName() + " " + p.getPrice()));
        session.close();
    }

    public void sortByPriceDesc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery(
                "from Product p order by p.price desc", Product.class);
        q.list().forEach(p -> 
            System.out.println(p.getName() + " " + p.getPrice()));
        session.close();
    }

    public void pagination(int start, int size) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query<Product> q = session.createQuery("from Product", Product.class);
        q.setFirstResult(start);
        q.setMaxResults(size);
        q.list().forEach(p -> System.out.println(p.getName()));
        session.close();
    }

    public void aggregateFunctions() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Long total = session.createQuery(
                "select count(p) from Product p", Long.class).uniqueResult();

        Object[] minMax = session.createQuery(
                "select min(p.price), max(p.price) from Product p",
                Object[].class).uniqueResult();

        System.out.println("Total Products: " + total);
        System.out.println("Min Price: " + minMax[0]);
        System.out.println("Max Price: " + minMax[1]);

        session.close();
    }
}
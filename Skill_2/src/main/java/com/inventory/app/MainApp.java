package main.java.com.inventory.app;

import main.java.com.inventory.dao.ProductDAO;
import main.java.com.inventory.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();
        Product p1 = new Product("Laptop", "Gaming Laptop", 75000, 5);
        Product p2 = new Product("Keyboard", "Mechanical Keyboard", 2500, 20);

        dao.addProduct(p1);
        dao.addProduct(p2);
        Product product = dao.getProductById(1);
        System.out.println("Retrieved: " + product);
        product.setPrice(72000);
        product.setQuantity(4);
        dao.updateProduct(product);
        dao.deleteProduct(2);

        System.out.println("CRUD operations completed.");
    }
}
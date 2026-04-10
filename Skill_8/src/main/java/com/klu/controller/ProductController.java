package com.klu.controller;

import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository repository;

    // Search by category
    @GetMapping("/category/{category}")
    public List<Product> getByCategory(@PathVariable String category){
        return repository.findByCategory(category);
    }

    // Filter by price range
    @GetMapping("/filter")
    public List<Product> filterPrice(@RequestParam double min,
                                     @RequestParam double max){
        return repository.findByPriceBetween(min, max);
    }

    // Sort by price
    @GetMapping("/sorted")
    public List<Product> sortedProducts(){
        return repository.sortProductsByPrice();
    }

    // Expensive products
    @GetMapping("/expensive/{price}")
    public List<Product> expensiveProducts(@PathVariable double price){
        return repository.findExpensiveProducts(price);
    }
}
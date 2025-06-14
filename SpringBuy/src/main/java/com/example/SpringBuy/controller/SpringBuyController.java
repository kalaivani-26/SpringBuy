package com.example.SpringBuy.controller;

import com.example.SpringBuy.model.Customer;
import com.example.SpringBuy.model.Order;
import com.example.SpringBuy.model.Product;
import com.example.SpringBuy.service.serviceimpl.SpringBuyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpringBuyController {
    @Autowired
    private SpringBuyServiceImpl springBuyService;

    @PostMapping("/api/products")
    public ResponseEntity<Product> SaveProduct(@RequestBody Product product) {
        Product saveProduct = springBuyService.saveProduct(product);
        return ResponseEntity.ok(saveProduct);
    }

    @PostMapping("/api/customers")
    public ResponseEntity<Customer> SaveCustomer(@RequestBody Customer customer) {
        Customer saveCustomer = springBuyService.saveCustomer(customer);
        return ResponseEntity.ok(saveCustomer);
    }

    @PostMapping("/api/ordersList")
    public ResponseEntity<Order> SaveOrder(@RequestBody Order order) {
        Order saveOrder = springBuyService.saveOrder(order);
        return ResponseEntity.ok(saveOrder);
    }

    @GetMapping("/api/getProducts")
    public ResponseEntity<List<Product>> GetProduct() {
        List<Product> productList = springBuyService.getProduct();
            return ResponseEntity.ok(productList);
    }
    @GetMapping("/api/getOrders")
    public ResponseEntity<List<Order>> GetOrder() {
        List<Order> OrderList = springBuyService.getOrder();
        return ResponseEntity.ok(OrderList);
    }
    @GetMapping("/api/getCustomers")
    public ResponseEntity<List<Customer>> GetCustomer() {
        List<Customer> customerList = springBuyService.getCustomer();
        return ResponseEntity.ok(customerList);
    }
}

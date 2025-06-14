package com.example.SpringBuy.service.serviceimpl;

import com.example.SpringBuy.dao.CustomerRepository;
import com.example.SpringBuy.dao.OrderRepository;
import com.example.SpringBuy.dao.ProductRepository;
import com.example.SpringBuy.model.Customer;
import com.example.SpringBuy.model.Order;
import com.example.SpringBuy.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpringBuyServiceImpl {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderRepository orderRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Order saveOrder(Order order) {
        Customer managedCustomer = customerRepository.findById(order.getCustomer().getId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        List<Product> managedProducts = order.getProducts().stream()
                .map(p -> productRepository.findById(p.getId())
                        .orElseThrow(() -> new RuntimeException("Product not found with id " + p.getId())))
                .collect(Collectors.toList());

        order.setCustomer(managedCustomer);
        order.setProducts(managedProducts);

        return orderRepository.save(order);
    }

    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    public List<Order> getOrder() {
        return orderRepository.findAll();
    }

    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
}

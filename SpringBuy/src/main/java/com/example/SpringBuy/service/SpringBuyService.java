package com.example.SpringBuy.service;

import com.example.SpringBuy.model.Product;
import org.springframework.stereotype.Service;

@Service
public  interface SpringBuyService {
    Product saveProduct(Product product);
}

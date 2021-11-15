package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    OrderService()
    {

    }

    public void createOrder(String order)
    {
        System.out.println("Order name " + order + "created");
    }
}

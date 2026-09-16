package com.eidiko.order_service.service;

import com.eidiko.order_service.client.ProductClient;
import com.eidiko.order_service.dto.ProductResponse;
import com.eidiko.order_service.entity.Order;
import com.eidiko.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public Order createOrder(Order order){
        ProductResponse product = productClient.getProductById(order.getProductId());

        double totalPrice = product.getPrice() * order.getQuantity();
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}

package com.eidiko.order_service.service;

import com.eidiko.order_service.dto.ProductResponse;
import com.eidiko.order_service.entity.Order;
import com.eidiko.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestClient restClient;

    public Order createOrder(Order order){
        ProductResponse product = restClient.get()
                .uri("http://localhost:9091/products/"+order.getProductId())
                .retrieve()
                .body(ProductResponse.class);

        double totalPrice = product.getPrice() * order.getQuantity();
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}

package com.eidiko.order_service.service;

import com.eidiko.order_service.client.ProductClient;
import com.eidiko.order_service.dto.ProductResponse;
import com.eidiko.order_service.entity.Order;
import com.eidiko.order_service.exception.ProductNotFoundException;
import com.eidiko.order_service.exception.ProductServiceUnavailableException;
import com.eidiko.order_service.repository.OrderRepository;
import feign.FeignException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Retry(name = "productService")
    @CircuitBreaker(name = "productService")
    public Order createOrder(Order order){
        ProductResponse product;
        try{
            product = productClient.getProductById(order.getProductId());
        }
        catch (FeignException.NotFound ex){
            throw new ProductNotFoundException("We did not get product with ID : "+order.getProductId());
        }catch (FeignException.ServiceUnavailable ex){
            throw new ProductServiceUnavailableException("*** Product Service is Unavailable ***");
        }

        double totalPrice = product.getPrice() * order.getQuantity();
        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}

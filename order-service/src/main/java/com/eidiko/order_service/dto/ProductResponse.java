package com.eidiko.order_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private double price;
    private String category;
}

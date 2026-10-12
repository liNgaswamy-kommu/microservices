package com.eidiko.order_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String message;
}
